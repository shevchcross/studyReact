package studyReact.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import studyReact.models.Film;

import java.util.Optional;


public interface FilmRepository extends JpaRepository<Film, Long> {
    Optional<Film> findByName(String name);
}
