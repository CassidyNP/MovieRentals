// Main class
// Contains starter testing code
// HW 2: Refactoring
// Cassidy Pena

public class Main {

    public static void main(String[] args){
        Customer customer = new Customer("Cassidy Pena");

        Movie regular = new RegularMovie("Sinners");
        Movie newRelease = new NewRelease("Scream 7");
        Movie children = new ChildrenMovie("Goat");

        customer.addRental(new Rental(regular, 5));
        customer.addRental(new Rental(newRelease, 2));
        customer.addRental(new Rental(children, 1));

        System.out.println(customer.outputStatement());
        System.out.println("\nXML Statement:\n");
        System.out.println(customer.xmlStatement());

    }
}
