package pl.air.cinema.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.air.cinema.model.FilmShow;


import java.util.Optional;

public interface FilmShowRepository extends JpaRepository<FilmShow, Long> {

Optional<FilmShow> deleteFilmShowById(Long id);

}
