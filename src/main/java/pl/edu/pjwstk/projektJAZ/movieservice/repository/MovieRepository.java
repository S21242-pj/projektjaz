package pl.edu.pjwstk.projektJAZ.movieservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projektJAZ.movieservice.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();

    Movie save(Movie movie);

    Optional<Movie> findById(Long aLong);

    void deleteById(Long id);

}

// https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
// https://www.samouczekprogramisty.pl/kurs-programowania-java/
