import java.util.*;

public class AwardWinningMovie extends Movie {
    private String awardTitle;
    private int awardYear;


    AwardWinningMovie(String title, String rating, String genre, String director, String star, String awardTitle, int awardYear) {
        super(title, rating, genre, director, star);
        setAwardTitle(awardTitle);
        setAwardYear(awardYear);
    }

    public String getAwardTitle() {
        return awardTitle;
    }

    public int getAwardYear() {
        return awardYear;
    }

    public void setAwardTitle(String awardTitle) {
        this.awardTitle = awardTitle;
    }

    public void setAwardYear(int awardYear) {
        this.awardYear = awardYear;
    }

    /**
     * This method prints menu of program
     */
    public void menu() {
        System.out.println("EXPERIMENTAL AWARD-WINNING MOVIE DATABASE");
        System.out.println();
        System.out.println("Choose an option from the menu.");
        System.out.println("1) Display a list of popular movies");
        System.out.println("2) Search the database ");
        System.out.println("3) Quit");
        System.out.println();
        System.out.print("Your Choice? ");
    }

    /**
     * This method prints movie info of the first 5 elements in arraylist of AwardWinningMovie obj  @param stuff arraylist of AwardWinningMovie objects
     */
    public void printPopMovies(ArrayList<AwardWinningMovie> stuff) {
        AwardWinningMovie movie;
        System.out.println();
        for (int i = 0; i < 5; i++) {
            movie = stuff.get(i);
            String cat = movie.getTitle();
            System.out.println(i + 1 + ") " + cat);
        }
    }

    /**
     * This method searches movie info of that has ID in the Title param of AwardWinningMovie obj  @param ID index, stuff arraylist of AwardWinningMovie objects
     */
    public AwardWinningMovie searchTitle(String ID, ArrayList<AwardWinningMovie> stuff) {
        AwardWinningMovie elem;
        for (AwardWinningMovie awardWinningMovie : stuff) {
            elem = awardWinningMovie;
            String title = elem.getTitle();
            boolean insens = title.toLowerCase().contains(ID.toLowerCase());
            if (insens) {
                return elem;
            }
        }
        return null;
    }

    /**
     * This method searches movie info of that has ID in the Star param of AwardWinningMovie obj  @param ID index, stuff arraylist of AwardWinningMovie objects
     */
    public AwardWinningMovie searchStar(String ID, ArrayList<AwardWinningMovie> stuff) {
        AwardWinningMovie elem;
        for (AwardWinningMovie awardWinningMovie : stuff) {
            elem = awardWinningMovie;
            String star = elem.getStar();
            boolean insens = star.toLowerCase().contains(ID.toLowerCase());
            if (insens) {
                return elem;
            }
        }
        return null;
    }

    /**
     * This method prints movie info of a AwardWinningMovie obj if its between 0-4 (1-5 for user)  @param ID index, stuff arraylist of AwardWinningMovie objects
     */
    public void printPopMoviesUser(int ID, ArrayList<AwardWinningMovie> stuff) {
        AwardWinningMovie elem;
        if (ID >= 0 && ID <= 4) {
            getMovies(ID, stuff);
        } else System.out.println("Please enter a number between 1-5!");
    }

    /**
     * This method gets movie info from index ID in the arraylist  @param ID index, stuff arraylist of AwardWinningMovie objects
     */
    public void getMovies(int ID, ArrayList<AwardWinningMovie> stuff) {
        AwardWinningMovie elem;
        elem = stuff.get(ID);
        print(elem);
    }

    /**
     * This method prints movie info of elem  @param elem the element in the arraylist
     */
    public void print(AwardWinningMovie elem) {
        System.out.println("Title: " + elem.getTitle());
        System.out.println("Rating: " + elem.getRating());
        System.out.println("Genre: " + elem.getGenre());
        System.out.println("Director: " + elem.getDirector());
        System.out.println("Star: " + elem.getStar());
        System.out.println("Award: " + elem.getAwardTitle() + ", " + elem.getAwardYear());
    }

    /**
     * This method checks user input for option 1 @param id the users input
     */
    public boolean checkPopNum(int id) {
        return id >= 0 && id <= 4;
    }

    public String toString() {
        return super.toString() + " " + awardTitle + awardYear;
    }

    public boolean equals(AwardWinningMovie obj1, AwardWinningMovie obj2) {
        String yeah = Integer.toString(obj2.getAwardYear());
        boolean param1 = obj1.getAwardTitle().equals(obj2.getAwardTitle());
        boolean param2 = Objects.equals(obj1.getAwardYear(), yeah);
        return super.equals(obj1, obj2);
    }
}