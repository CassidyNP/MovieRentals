/* Movie Class
    - Major Changes:
        - made into an abstract class
        - added calculateAmount() and calculateFrequentRenterPoints()
*/
public abstract class Movie {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateAmount(int daysRented);

    public abstract int calculateFrequentRenterPoints(int daysRented);

}