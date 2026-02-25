public class RegularMovie extends Movie{

    public RegularMovie(String title) {
        super(title);
    }

    // check this math later
    @Override
    public double calculateAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }

    // check this later
    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
