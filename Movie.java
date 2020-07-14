public class Movie {
    private String title;
    private String rating;
    private String genre;
    private String director;
    private String star;


    Movie(String title, String rating, String genre, String director, String star){
        this.title = title;
        this.rating = rating;
        this.genre = genre;
        this.director = director;
        this.star = star;
    }

    public String getTitle() {
        return title;
    }
    public String getRating() {
        return rating;
    }
    public String getGenre() {
        return genre;
    }
    public String getDirector() {
        return director;
    }
    public String getStar() {
        return star;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setStar(String star) {
        this.star = star;
    }

    public String toString(){
        return title +" "+ rating +" "+ genre +" "+ director + " " + star;
    }

    public boolean equals(Movie obj1, Movie obj2){
        boolean param1 = obj1.getTitle().equals(obj2.getTitle());
        boolean param2 = obj1.getRating().equals(obj2.getRating());
        boolean param3 = obj1.getGenre().equals(obj2.getGenre());
        boolean param4 = obj1.getDirector().equals(obj2.getDirector());
        boolean param5 = obj1.getStar().equals(obj2.getStar());

        return param1 && param2 && param3 && param4 && param5;
    }

}
