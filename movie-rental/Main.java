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

        /*-----Second Customer-----*/

        Customer customer2 = new Customer("Elsha");

        Movie regular2 = new RegularMovie("Hamnet");
        Movie newRelease2 = new NewRelease("Bugonia");
        Movie children2 = new ChildrenMovie("Moana");

        customer2.addRental(new Rental(regular2, 7));
        customer2.addRental(new Rental(newRelease2, 6));
        customer2.addRental(new Rental(children2, 2));

        System.out.println("\n");
        System.out.println(customer2.outputStatement());
        System.out.println("\nXML Statement:\n");
        System.out.println(customer2.xmlStatement());


    }
}
