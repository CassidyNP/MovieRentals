/* Customer class
    - Major Changes:
        - Seperated the original statement method into smaller purposeful methods
        - Changes Vector to ArrayList data structure
        - Added the xml statement
        - Statement() --> outputStatement() with only one purpose
*/
import java.util.*;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private int frequentRentalPoints = 0;

    public Customer(String name){
        this.name = name;
    }


    public void addRental(Rental rental){
        rentals.add(rental);
    }

    public String getName(){
        return name;
    }

    // iterate through rentals and add up the rental points
    public void updateFrequentRentalPoints(){
        frequentRentalPoints = 0;
        for (Rental rental : rentals) {
            frequentRentalPoints += rental.getFrequentRenterPoints();
        }
    }

    // iterate through rentals and add up total price amount of movies rented
    private double calculateTotalPrice(){
        double totalPrice = 0;
        for(Rental rental : rentals){
            totalPrice += rental.computeRentalPrice();
        }
        return totalPrice;
    }

    private String getFooter(double totalPrice){
        String footer = "";
        footer = "Amount owed is " + totalPrice + "\n" +
                "You earned " + frequentRentalPoints + " frequent rental points";
        return footer;
    }

    // method for printing the original statement [not xml]
    public String outputStatement(){
        updateFrequentRentalPoints();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n" );

        for(Rental rental : rentals){
            // format the output so that movies and price are fixed
            result.append(String.format("%-15s %10.2f\n",
                    rental.getMovie().getTitle(),
                    rental.computeRentalPrice()));
        }

        double totalPrice = calculateTotalPrice();
        result.append(getFooter(totalPrice));
        return result.toString();
    }

    // add a new method to print the statement for customer in XML format
    public String xmlStatement(){
        updateFrequentRentalPoints();
        StringBuilder result = new StringBuilder();
        result.append("<customer>\n");
        result.append("<name>").append(name).append("</name>\n");

        for(Rental rental : rentals){
            result.append("<rental>\n");
            result.append("\t<movie>").append(rental.getMovie().getTitle()).append("</movie>\n");
            result.append("\t<days>").append(rental.getDaysRented()).append("</days>\n");
            result.append("\t<amount>").append(rental.computeRentalPrice()).append("</amount>\n");
            result.append("</rental>\n");
        }

        result.append("\t<total>").append(calculateTotalPrice()).append("</total>\n");
        result.append("\t<frequentPoints>").append(frequentRentalPoints).append("</frequentPoints>\n");
        result.append("</customer>");

        return result.toString();
    }

}