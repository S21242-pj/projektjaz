package pl.edu.pjwstk.projektJAZ.movieservice.model;

import lombok.NonNull;
import pl.edu.pjwstk.projektJAZ.movieservice.enums.Categories;

import javax.persistence.*;

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String movieName;
    @Enumerated(EnumType.STRING)
    private Categories movieCategory;

    @NonNull
    private boolean isAvailable = false;

    public Long getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Categories getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(Categories movieCategory) {
        this.movieCategory = movieCategory;
    }


}

