
public class ChildrenMovie extends Movie{

    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        double totalAmount = 1.5;
        if (daysRented > 3) {
            totalAmount += (daysRented - 3) * 1.5;
        }
        return totalAmount;
    }

    // Children's Movie only gets one renter point
    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
