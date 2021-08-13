package pl.air.cinema.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.air.cinema.model.Director;
import pl.air.cinema.model.Movie;
import pl.air.cinema.model.Star;

import java.util.List;
import java.util.Optional;

public interface StarRepository extends JpaRepository<Star, Long> {
    List<Star> findAllByMovies(Movie movie);
    Optional<Star> findAllByFirstNameAndLastName(String firstName, String lastName);
    Optional<Star> deleteStarById(Long id);
}
