import java.util.*;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private int frequentRentalPoints = 0;

    // Customer Constructor
    public Customer(String name){
        this.name = name;
    }

    //
    public void addRental(Rental rental){
        rentals.add(rental);
    }

    public String getName(){return name;}

    public void updateFrequentRentalPoints(){
        frequentRentalPoints = 0;
        for(Rental rental : rentals) {
            frequentRentalPoints += rental.getFrequentRenterPoints();
        }
    }

    private double calculateTotalAmount(){
        double totalAmount = 0;
        for(Rental rental : rentals){
            totalAmount += rental.computeRentalPrice();
        }
        return totalAmount;
    }

    private String getFooter(double totalAmount){
        String footer = "";
        footer = "Amount owed is " + totalAmount + "\n" +
                "You earned " + frequentRentalPoints + " frequent rental points";
        return footer;
    }

    public String statement(){
        updateFrequentRentalPoints();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n" );

        for(Rental rental : rentals){
            result.append("\t").append(rental.getMovie().getTitle())
                    .append("\t").append(rental.computeRentalPrice())
                    .append("\n");
        }

        double totalAmount = calculateTotalAmount();
        result.append(getFooter(totalAmount));
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

        result.append("\t<total>").append(calculateTotalAmount()).append("</total>\n");
        result.append("\t<frequentPoints>").append(frequentRentalPoints).append("</frequentPoints>\n");
        result.append("</customer>");

        return result.toString();
    }

}