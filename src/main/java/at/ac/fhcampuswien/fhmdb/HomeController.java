package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    @FXML
    public JFXButton deleteBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        genreComboBox.getItems().addAll(Arrays.asList(Genre.values()));
        genreComboBox.setPromptText("Filter by Genre");

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        searchBtn.setOnAction(actionEvent -> {
            String searchTerm = searchField.getText().toLowerCase();
            Genre selectedGenre = (Genre) genreComboBox.getValue();
            List<Movie> filteredMovies = new ArrayList<>();

            List<Movie> searchResult = searchMovies(searchTerm);
            List<Movie> genreResult = filterMoviesByGenre(selectedGenre);

            filteredMovies.addAll(innerJoinMovies(searchResult, genreResult));

            observableMovies.clear();
            observableMovies.addAll(filteredMovies);
        });


        sortBtn.setOnAction(actionEvent -> {
            boolean isAscending  = false;
            if(sortBtn.getText().equals("Sort (asc)  ")) {
                isAscending = true;
                sortBtn.setText("Sort (desc)");
            } else {
                sortBtn.setText("Sort (asc)  ");
            }
            observableMovies = (ObservableList<Movie>) sortMovies(observableMovies, isAscending);
        });

        deleteBtn.setOnAction(actionEvent -> {
            searchField.setText("");
            genreComboBox.setValue(null);

            observableMovies.clear();
            observableMovies.addAll(allMovies);
        });

    }

    static List<Movie> sortMovies(List<Movie> movies, boolean ascending) { //default access modifier
        Collections.sort(movies);

        if (! ascending)
        {
            Collections.reverse(movies);
        }
        return movies;
    }

    List<Movie> searchMovies(String searchTerm)
    {
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie : allMovies) {
                if (movie.getTitle().toLowerCase().contains(searchTerm) || movie.getDescription().toLowerCase().contains(searchTerm)) {
                    filteredMovies.add(movie);
                }
            }
        return filteredMovies;
    }

    List<Movie> filterMoviesByGenre(Genre selectedGenre)
    {
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie : allMovies) {
                if (movie.getGenre().contains(selectedGenre) || selectedGenre == null) {
                    filteredMovies.add(movie);
                }
            }
        return filteredMovies;
    }

    // ? has to be replaced with streams after next lecture
    static List<Movie> innerJoinMovies (List<Movie> listOne, List<Movie> listTwo)
    {
        //Inner Join: https://www.w3schools.com/sql/img_innerjoin.gif
        List<Movie> joinedMovies = new ArrayList<>();
        for (Movie m : listOne) {
                if(listTwo.contains(m))
                    joinedMovies.add(m);
            }
        return joinedMovies;
    }
}