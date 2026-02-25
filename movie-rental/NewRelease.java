public class NewRelease extends Movie {
    public NewRelease(String title) {
        super(title);
    }

    // check this math later
    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 3;
    }

    // check this math later
    @Override
    public int calculateFrequentRenterPoints(int daysRented){
        return daysRented > 1 ? 2 : 1;
    }
}
