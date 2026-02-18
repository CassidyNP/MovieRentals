// this class has the following code smells:
// - data class: this class is a data class because it only has data and no behavior
// - primitive obsession: this class uses primitive types (int, double) to represent concepts that could be represented with more meaningful types (e.g. Money, DaysRented). This makes the
// code less readable and maintainable because it is not clear what the primitive types represent and how they should be used. Using more meaningful types would improve the readability and maintainability of the code by making it clear what the data represents and how it should be used.
public class Movie {

    // this is an example of the code smell 
    // magic numbers. The price codes (0, 1, 2) are magic numbers. 
    // They should be replaced with constants to make the code more readable
    //  and maintainable.
    public static final int CHILDRENS   = 2;
    public static final int REGULAR     = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int    _priceCode;
    
    // code smell: should us the this key word to refer to the instance variables to make it clear that we are referring to the instance variables and not local variables. This will improve the readability of the code and make it easier to understand.
    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }
    
    public int getPriceCode() {
        return _priceCode;
    }
    
    public void setPriceCode(int arg) {
        _priceCode = arg;
    }
    
    public String getTitle() {
        return _title;
    }
}