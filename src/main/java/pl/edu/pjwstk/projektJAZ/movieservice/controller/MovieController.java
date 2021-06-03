package pl.edu.pjwstk.projektJAZ.movieservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.projektJAZ.movieservice.exceptions.ResourceAlreadyExistException;
import pl.edu.pjwstk.projektJAZ.movieservice.exceptions.ResourceNotFoundException;
import pl.edu.pjwstk.projektJAZ.movieservice.model.Movie;
import pl.edu.pjwstk.projektJAZ.movieservice.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/test")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        try {
            movieService.addMovie(movie);
            return ResponseEntity.ok(movieService.addMovie(movie));
        } catch (ResourceAlreadyExistException e) {

            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> addMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie,
                                          @PathVariable Long id) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        try {
            movieService.deleteMovieById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/movies/{id}/isAvailable")
    public ResponseEntity<Void> isAvailable(@PathVariable Long id) {
        movieService.isAvailable(id);
        return ResponseEntity.ok().build();
    }
}



