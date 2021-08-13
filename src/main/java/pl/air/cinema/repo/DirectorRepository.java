package pl.air.cinema.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.air.cinema.model.Director;

import java.util.Optional;


public interface DirectorRepository extends JpaRepository<Director, Long> {

    Optional<Director> findAllByFirstNameAndLastName(String firstName, String lastName);
    Optional<Director> deleteDirectorById(Long id);



}
