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

            for (Movie movie : allMovies) {
                boolean matchesSearchTerm = movie.getTitle().toLowerCase().contains(searchTerm) || movie.getDescription().toLowerCase().contains(searchTerm);
                boolean matchesSelectedGenre = selectedGenre == null || movie.getGenre().contains(selectedGenre);
                if (matchesSearchTerm && matchesSelectedGenre) {
                    filteredMovies.add(movie);
                }
            }

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

    public ObservableList<Movie> getObservableMovies() {
        return observableMovies;
    }

    List<Movie> sortMovies(List<Movie> movies, boolean ascending) { //default access modifier
        Collections.sort(movies);

        if (! ascending)
        {
            Collections.reverse(movies);
        }
        return movies;
    }
}