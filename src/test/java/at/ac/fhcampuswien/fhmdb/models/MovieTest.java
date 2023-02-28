package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void movie_a_compared_to_movie_b_returns_negative_number()
    {
        //Given
        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.ACTION);
        Movie a = new Movie("a", "this is movie a", genres);
        Movie b = new Movie("b", "this is movie b", genres);

        //When
        int actual = a.compareTo(b);

        //Then
        int expected = -1;
        assertEquals(expected, actual);
    }
}