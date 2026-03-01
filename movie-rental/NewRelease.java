public class NewRelease extends Movie {
    public NewRelease(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 3;
    }

    // for new releases if it is rented more than 1 day the customer gets 2 points
    @Override
    public int calculateFrequentRenterPoints(int daysRented){
        int renterPoint = 0;

        if(daysRented > 1){
            renterPoint = 2;
        }else{
            renterPoint = 1;
        }
        return renterPoint;
    }
}
