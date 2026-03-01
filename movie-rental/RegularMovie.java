public class RegularMovie extends Movie{

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        double totalAmount = 2;
        if (daysRented > 2) {
            totalAmount += (daysRented - 2) * 1.5;
        }
        return totalAmount;
    }

    // Regular movie also only gets 1 renter point
    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
