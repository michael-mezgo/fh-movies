package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Comparable<Movie>{
    private String title;
    private String description;
    private List<Genre> genre;
    public Movie(String title, String description, List<Genre> genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here

        List<Genre> genresFirstMovie = new ArrayList<>();
        genresFirstMovie.add(Genre.ADVENTURE);
        genresFirstMovie.add(Genre.ACTION);
        Movie myMovie = new Movie("title", "description", genresFirstMovie);

        List<Genre> genresSecondMovie = new ArrayList<>();
        genresSecondMovie.add(Genre.CRIME);
        genresSecondMovie.add(Genre.DRAMA);
        Movie myOtherMovie = new Movie("Group project", "technical difficulties", genresSecondMovie);

        List<Genre> genresThirdMovie = new ArrayList<>();
        genresThirdMovie.add(Genre.ROMANCE);
        genresThirdMovie.add(Genre.FAMILY);
        Movie myThirdMovie = new Movie("Networking technologies", "is fun", genresThirdMovie);

        movies.add(myMovie);
        movies.add(myOtherMovie);
        movies.add(myThirdMovie);

        return movies;
    }

    @Override
	public int compareTo(Movie m) {
		return this.getTitle().compareTo(m.getTitle());
	}
}
