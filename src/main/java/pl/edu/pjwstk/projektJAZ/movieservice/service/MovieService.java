package pl.edu.pjwstk.projektJAZ.movieservice.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pjwstk.projektJAZ.movieservice.exceptions.ResourceNotFoundException;
import pl.edu.pjwstk.projektJAZ.movieservice.model.Movie;
import pl.edu.pjwstk.projektJAZ.movieservice.repository.MovieRepository;



@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Movie updateMovie(Long id, Movie movie) {
        var movieToUpdate = getMovieById(id);
        if (movie.getTitle() != null) {
            movieToUpdate.setTitle(movie.getTitle());
        }
        if (movie.getCategories() != null) {
            movieToUpdate.setCategories(movie.getCategories());
        }
        return addMovie(movieToUpdate);
    }

    public void deleteMovieById(Long id) {
        if (!movieRepository.findAll().removeIf(movie -> movie.getId().equals(id))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        movieRepository.deleteById(id);
    }

    /**
     * Homework 6 lesson
     */

    public void isAvailable(Long id) {
        var movie = getMovieById(id);
        movie.setAvailable(true);
        addMovie(movie);
    }
}