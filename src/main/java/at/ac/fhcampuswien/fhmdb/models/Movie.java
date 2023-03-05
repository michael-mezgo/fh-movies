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

        List<Genre> genresDarkKnight = new ArrayList<>();
        genresDarkKnight.add(Genre.ACTION);
        genresDarkKnight.add(Genre.CRIME);
        genresDarkKnight.add(Genre.DRAMA);
        Movie darkKnight = new Movie("The Dark Knight", "The Joker wreaks havoc on Gotham City while Batman tries to stop him in this dark and thrilling superhero film.", genresDarkKnight);

        List<Genre> genresInception = new ArrayList<>();
        genresInception.add(Genre.ACTION);
        genresInception.add(Genre.ADVENTURE);
        genresInception.add(Genre.SCIENCE_FICTION);
        Movie inception = new Movie("Inception", "A thief who steals corporate secrets through dream-sharing technology is tasked with planting an idea in this mind-bending sci-fi thriller.", genresInception);

        List<Genre> genresUp = new ArrayList<>();
        genresUp.add(Genre.ANIMATION);
        genresUp.add(Genre.ADVENTURE);
        genresUp.add(Genre.COMEDY);
        Movie up = new Movie("Up", "An elderly man and a young boy scout travel to South America in a house lifted by helium balloons in this heartwarming and adventurous animated film.", genresUp);

        List<Genre> genresAvengers = new ArrayList<>();
        genresAvengers.add(Genre.ACTION);
        genresAvengers.add(Genre.ADVENTURE);
        genresAvengers.add(Genre.SCIENCE_FICTION);
        Movie avengers = new Movie("The Avengers", "A group of superheroes band together to stop an alien invasion led by Thor's adopted brother, Loki, in this action-packed and epic comic book adaptation.", genresAvengers);

        List<Genre> genresHungerGames = new ArrayList<>();
        genresHungerGames.add(Genre.ACTION);
        genresHungerGames.add(Genre.ADVENTURE);
        genresHungerGames.add(Genre.SCIENCE_FICTION);
        Movie hungerGames = new Movie("The Hunger Games", "A teenage girl volunteers to take her younger sister's place in a televised fight to the death in this thrilling and dystopian sci-fi adventure.", genresHungerGames);

        List<Genre> genresFindingNemo = new ArrayList<>();
        genresFindingNemo.add(Genre.ANIMATION);
        genresFindingNemo.add(Genre.ADVENTURE);
        genresFindingNemo.add(Genre.COMEDY);
        Movie findingNemo = new Movie("Finding Nemo", "A clownfish sets out on a dangerous journey to find his son, who has been captured by divers, in this charming and visually stunning animated film.", genresFindingNemo);

        List<Genre> genresArrival = new ArrayList<>();
        genresArrival.add(Genre.SCIENCE_FICTION);
        genresArrival.add(Genre.DRAMA);
        Movie arrival = new Movie("Arrival", "When mysterious spacecraft touch down across the globe, a linguistics professor and her team race against time to interpret the aliens' language.", genresArrival);

        List<Genre> genresGetOut = new ArrayList<>();
        genresGetOut.add(Genre.HORROR);
        genresGetOut.add(Genre.MYSTERY);
        genresGetOut.add(Genre.THRILLER);
        Movie getOut = new Movie("Get Out", "A young African-American man visits his white girlfriend's parents for the weekend, where his simmering uneasiness about their reception of him eventually reaches a boiling point in this chilling and socially relevant horror film.", genresGetOut);

        List<Genre> genresMadMax = new ArrayList<>();
        genresMadMax.add(Genre.ACTION);
        genresMadMax.add(Genre.ADVENTURE);
        genresMadMax.add(Genre.SCIENCE_FICTION);
        Movie madMax = new Movie("Mad Max: Fury Road", "In a post-apocalyptic world, a woman rebels against a tyrannical ruler in search for her homeland with the aid of a group of female prisoners, a psychotic worshiper, and a drifter named Max in this exhilarating and intense action film.", genresMadMax);

        List<Genre> genresTitans = new ArrayList<>();
        genresTitans.add(Genre.BIOGRAPHY);
        genresTitans.add(Genre.DRAMA);
        genresTitans.add(Genre.SPORT);
        Movie titans = new Movie("Remember the Titans", "The true story of a newly appointed African-American coach and his high school team on their first season as a racially integrated unit in this inspiring and emotional sports drama.", genresTitans);


        movies.add(darkKnight);
        movies.add(inception);
        movies.add(up);
        movies.add(avengers);
        movies.add(hungerGames);
        movies.add(arrival);
        movies.add(getOut);
        movies.add(findingNemo);
        movies.add(madMax);
        movies.add(titans);

        return movies;
    }

    @Override
	public int compareTo(Movie m) {
		return this.getTitle().compareTo(m.getTitle());
	}
}
