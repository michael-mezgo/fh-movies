package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    /*
    * An int value: 0 if the string is equal to the other string.
    * < 0 if the string is lexicographically less than the other string
    * > 0 if the string is lexicographically greater than the other string (more characters)
    * Source: https://www.w3schools.com/java/ref_string_compareto.asp
     */
    @Test
    void movie_a_compared_to_movie_b_returns_negative_1()
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

    @Test
    void movie_b_compared_to_movie_a_returns_positive_1()
    {
        //Given
        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.ACTION);
        Movie a = new Movie("a", "this is movie a", genres);
        Movie b = new Movie("b", "this is movie b", genres);

        //When
        int actual = b.compareTo(a);

        //Then
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void movie_a_compared_to_movie_a_returns_0()
    {
        //Given
        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.ACTION);
        Movie a1 = new Movie("a", "this is movie a", genres);
        Movie a2 = new Movie("a", "this is movie a", genres);

        //When
        int actual = a1.compareTo(a2);

        //Then
        int expected = 0;
        assertEquals(expected, actual);
    }
}