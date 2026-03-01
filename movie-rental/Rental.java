/* Rental Class
    - Major Changes:
        - Added computeRentalPrice() and getFrequentRenterPoints()
*/
public class Rental {
    private Movie movie;
    private int   daysRented;
    
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie(){
        return movie;
    }

    public int getDaysRented(){
        return daysRented;
    }

    public double computeRentalPrice(){
        return movie.calculateAmount(daysRented);
    }

    public int getFrequentRenterPoints(){
        return movie.calculateFrequentRenterPoints(daysRented);
    }
}