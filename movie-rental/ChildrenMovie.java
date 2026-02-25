// to do:
// check the math later on these methods

public class ChildrenMovie extends Movie{

    public ChildrenMovie(String title) {
        super(title);
    }

    // check this math later
    @Override
    public double calculateAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        return amount;
    }

    // check this later
    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
