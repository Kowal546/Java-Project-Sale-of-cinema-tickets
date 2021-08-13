package pl.air.cinema.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.air.cinema.model.Director;
import pl.air.cinema.model.Movie;
import pl.air.cinema.model.Star;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);
    List<Movie> findAllByDirector(Director director);
    List<Movie> findAllByStars(Star star);
    Optional<Movie> deleteMovieById(Long id);


}
