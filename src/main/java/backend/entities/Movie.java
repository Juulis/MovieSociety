package backend.entities;

public class Movie {
    private String title;
    private String released;
    private String genre;

    public Movie(String title, String released, String genre) {
        this.title = title;
        this.released = released;
        this.genre = genre;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
