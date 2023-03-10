package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeControllerTest {
    @Test
    void sort_movies_ascending_returns_movies_sorted() {
        // Given
        boolean isAscending = true;

        //region createMovies
        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.ACTION);

        Movie a = new Movie("a", "this is movie a", genres);
        Movie b = new Movie("b", "this is movie b", genres);
        Movie aa = new Movie("aa", "this is movie aa", genres);
        Movie ab = new Movie("ab", "this is movie ab", genres);
        //endregion

        List<Movie> givenMovies = new ArrayList<Movie>();
        givenMovies.add(b);
        givenMovies.add(a);
        givenMovies.add(ab);
        givenMovies.add(aa);

        List<Movie> expected = new ArrayList<Movie>();

        expected.add(a);
        expected.add(aa);
        expected.add(ab);
        expected.add(b);

        HomeController homeController = new HomeController();

        // When
        List<Movie> actual = homeController.sortMovies(givenMovies, isAscending);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void sort_movies_descending_returns_movies_sorted() {
        // Given
        boolean isAscending = false;

        //region createMovies
        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.ACTION);

        Movie a = new Movie("a", "this is movie a", genres);
        Movie b = new Movie("b", "this is movie b", genres);
        Movie aa = new Movie("aa", "this is movie aa", genres);
        Movie ab = new Movie("ab", "this is movie ab", genres);
        //endregion

        List<Movie> givenMovies = new ArrayList<Movie>();
        givenMovies.add(b);
        givenMovies.add(a);
        givenMovies.add(ab);
        givenMovies.add(aa);

        List<Movie> expected = new ArrayList<Movie>();

        expected.add(b);
        expected.add(ab);
        expected.add(aa);
        expected.add(a);

        HomeController homeController = new HomeController();

        // When
        List<Movie> actual = homeController.sortMovies(givenMovies, isAscending);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void search_term_delivers_back_movies_with_search_term_returns_nemo() {
        //Given
        //region CreateMovies
        List<Movie> givenMovies = new ArrayList<>();

        List<Genre> genresFindingNemo = new ArrayList<>();
        genresFindingNemo.add(Genre.ANIMATION);
        genresFindingNemo.add(Genre.ADVENTURE);
        genresFindingNemo.add(Genre.COMEDY);
        Movie findingNemo = new Movie("Finding Nemo", "A clownfish sets out on a dangerous journey to find his son, who has been captured by divers, in this charming and visually stunning animated film.", genresFindingNemo);
        givenMovies.add(findingNemo);

        List<Genre> genresHungerGames = new ArrayList<>();
        genresHungerGames.add(Genre.ACTION);
        genresHungerGames.add(Genre.ADVENTURE);
        genresHungerGames.add(Genre.SCIENCE_FICTION);
        givenMovies.add(new Movie("The Hunger Games", "A teenage girl volunteers to take her younger sister's place in a televised fight to the death in this thrilling and dystopian sci-fi adventure.", genresHungerGames));
        //endregion

        HomeController homeController = new HomeController();
        String searchTerm = "nemo";

        homeController.allMovies.clear();
        homeController.allMovies.addAll(givenMovies);

        //When
        List<Movie> filteredMovies = homeController.searchMovies(searchTerm);

        //Then
        assertEquals(1, filteredMovies.size());
        assertEquals(findingNemo, filteredMovies.get(0));
    }

    @Test
    void set_genre_delivers_back_movies_with_genre_returns_nemo() {
        //Given
        //region CreateMovies
        List<Movie> givenMovies = new ArrayList<>();

        List<Genre> genresFindingNemo = new ArrayList<>();
        genresFindingNemo.add(Genre.ANIMATION);
        genresFindingNemo.add(Genre.ADVENTURE);
        genresFindingNemo.add(Genre.COMEDY);
        Movie findingNemo = new Movie("Finding Nemo", "A clownfish sets out on a dangerous journey to find his son, who has been captured by divers, in this charming and visually stunning animated film.", genresFindingNemo);
        givenMovies.add(findingNemo);

        List<Genre> genresHungerGames = new ArrayList<>();
        genresHungerGames.add(Genre.ACTION);
        genresHungerGames.add(Genre.ADVENTURE);
        genresHungerGames.add(Genre.SCIENCE_FICTION);
        givenMovies.add(new Movie("The Hunger Games", "A teenage girl volunteers to take her younger sister's place in a televised fight to the death in this thrilling and dystopian sci-fi adventure.", genresHungerGames));
        //endregion

        HomeController homeController = new HomeController();
        Genre genreFilter = Genre.ANIMATION;

        homeController.allMovies.clear();
        homeController.allMovies.addAll(givenMovies);

        //When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(genreFilter);

        //Then
        assertEquals(1, filteredMovies.size());
        assertEquals(findingNemo, filteredMovies.get(0));
    }

    @Test
    void set_genre_delivers_back_movies_with_genre_returns_no_movie() {
        //Given
        //region CreateMovies
        List<Movie> givenMovies = new ArrayList<>();

        List<Genre> genresFindingNemo = new ArrayList<>();
        genresFindingNemo.add(Genre.ANIMATION);
        genresFindingNemo.add(Genre.ADVENTURE);
        genresFindingNemo.add(Genre.COMEDY);
        Movie findingNemo = new Movie("Finding Nemo", "A clownfish sets out on a dangerous journey to find his son, who has been captured by divers, in this charming and visually stunning animated film.", genresFindingNemo);
        givenMovies.add(findingNemo);

        List<Genre> genresHungerGames = new ArrayList<>();
        genresHungerGames.add(Genre.ACTION);
        genresHungerGames.add(Genre.ADVENTURE);
        genresHungerGames.add(Genre.SCIENCE_FICTION);
        givenMovies.add(new Movie("The Hunger Games", "A teenage girl volunteers to take her younger sister's place in a televised fight to the death in this thrilling and dystopian sci-fi adventure.", genresHungerGames));
        //endregion

        HomeController homeController = new HomeController();
        Genre genreFilter = Genre.DRAMA;

        homeController.allMovies.clear();
        homeController.allMovies.addAll(givenMovies);

        //When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(genreFilter);

        //Then
        assertEquals(0, filteredMovies.size());
    }

    @Test
    void join_two_lists_returns_common_movie_movB() {
        List<Genre> genres = List.of(new Genre[]{Genre.ACTION});
        Movie movA = new Movie("a", "movie a", genres);
        Movie movB = new Movie("b", "movie b", genres);
        Movie movC = new Movie("c", "movie c", genres);

        List<Movie> listOne = new ArrayList<>();
        List<Movie> listTwo = new ArrayList<>();

        listOne.add(movA);
        listOne.add(movB);
        listTwo.add(movB);
        listTwo.add(movC);

        List<Movie> actual = HomeController.innerJoinMovies(listOne, listTwo);

        assertEquals(1, actual.size());
        assertEquals(movB, actual.get(0));
    }

    @Test
    void join_two_lists_returns_common_movie_noMovies() {
        List<Genre> genres = List.of(new Genre[]{Genre.ACTION});
        Movie movA = new Movie("a", "movie a", genres);
        Movie movB = new Movie("b", "movie b", genres);
        Movie movC = new Movie("c", "movie c", genres);
        Movie movD = new Movie("d", "movie d", genres);

        List<Movie> listOne = new ArrayList<>();
        List<Movie> listTwo = new ArrayList<>();

        listOne.add(movA);
        listOne.add(movB);
        listTwo.add(movC);
        listTwo.add(movD);

        List<Movie> actual = HomeController.innerJoinMovies(listOne, listTwo);

        assertEquals(0, actual.size());
    }
}