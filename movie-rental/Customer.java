// some of the naming conventions for this file are not good. For example, the name of the class is Customer

// code smells in this file include:
// - long method: the statement() method is long and complex. It needs to be refactored.
// - switch statement: the switch statement in the statement() method is a code smell. It should be replaced with polymorphism to make the code more maintainable and extensible.
// - magic numbers: the price codes (0, 1, 2) are magic numbers. They should be replaced with constants to make the code more readable and maintainable.
// - duplicate code: the calculation of the amount for each rental is duplicated in the switch statement. This code should be extracted into a separate method to reduce duplication and improve maintainability.
// - unclear variable names: some of the variable names are not clear. For example, "each" does not indicate what it is. It should be renamed to something more meaningful, such as "rental" or "currentRental" to improve readability and maintainability.
// - lack of error handling: there is no error handling in the code. For example, if an invalid price code is passed to the Movie constructor, the code will not handle it gracefully. Error handling should be added to make the code more robust and prevent it from crashing in unexpected situations.           

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    // code smell: name of the variables are not meaningful.
    private String _name;
    private Vector _rentals = new Vector();
    
    // code 
    public Customer (String name) {
        _name = name;
    }
    
    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }
    
    public String getName() {
        return _name;
    }
    
    // the naming of this function is also bad because it does more than just create a statement. It also calculates the frequent renter points and the total amount. So the name should be something like generateStatement or something that indicates that it is doing more than just creating a statement.
    // This method is long and complex. It needs to be refactored. - what smell --> what quality is violated? --> maintainability
    public String statement() {
    
        // code smell
        double      totalAmount          = 0;
        int         frequentRenterPoints = 0;
        // code s
        Enumeration rentals              = _rentals.elements();
        String      result               = "Rental Record for " + getName() + "\n";
        
        // once you change this you can say rental.getRentalPrice() and it will be more clear what you are doing. It will also make the code more maintainable because if you need to change the way the price is calculated, you only need to change it in one place instead of changing it in multiple places in the switch statement.

        // code 
        while (rentals.hasMoreElements()) {
            
            // total amount but thisAmount does not make sense 
            double thisAmount = 0;
            Rental each       = (Rental) rentals.nextElement();
            
            // determine amounts for each line
            // one more needed switch case should be added to handle the case where the price code is not one of the expected values. This will make the code more robust and prevent it from crashing if an unexpected value is encountered.
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }
            // missed a default case here. It should be added to handle the case where the price code is not one of the expected values.
            
            // someone else should do this -- the funciton is called statement, not frequentRenterPoints
            //
            // add frequent renter points
            frequentRenterPoints++;
            
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                (each.getDaysRented() > 1)) {
                    frequentRenterPoints++;
            }
            
            // show figures for this rental
            // reduce the responsibility of this method by moving the formatting of the line items to a separate method
            // code sm
            result += "\t" + each.getMovie().getTitle() +
                      "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        
        // add footer lines
        // code smell
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                  " frequent renter points";
        return result;
    }
}