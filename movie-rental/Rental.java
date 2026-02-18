// this class has the following code smells:
// - data class: this class is a data class because it only has data and no behavior which is bad because 
// - primitive obsession: this class uses primitive types (int, double) to represent concepts that could be represented with more meaningful types (e.g. Money, DaysRented). This makes the code less readable and maintainable because it is not clear what the primitive types represent and how they should be used. Using more meaningful types would improve the readability and maintainability of the code by making it clear what the data represents and how it should be used.

public class Rental {
    private Movie _movie;
    private int   _daysRented;
    
    public Rental(Movie movie, int daysRented) {
        _movie      = movie;
        _daysRented = daysRented;
    }
    
    public int getDaysRented() {
        return _daysRented;
    }
    
    public Movie getMovie() {
        return _movie;
    }
}