package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    @Test
    void sort_movies_ascending_returns_movies_sorted() {
        // Given
        boolean isAscending = true;

        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.ACTION);

        Movie a = new Movie("a", "this is movie a", genres);
        Movie b = new Movie("b", "this is movie b", genres);
        Movie aa = new Movie("aa", "this is movie aa", genres);
        Movie ab = new Movie("ab", "this is movie ab", genres);

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

        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.ACTION);

        Movie a = new Movie("a", "this is movie a", genres);
        Movie b = new Movie("b", "this is movie b", genres);
        Movie aa = new Movie("aa", "this is movie aa", genres);
        Movie ab = new Movie("ab", "this is movie ab", genres);

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
    void demo_failing_test() {
        assertTrue(false);
    }
}