package studyReact.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import studyReact.models.Film;

import java.util.Optional;


public interface FilmRepository extends JpaRepository<Film, Long> {
    Optional<Film> findByName(String name);

    @Modifying
    @Query(value = "ALTER SEQUENCE film_id RESTART WITH 1;", nativeQuery = true)
    void deleteSequence();
}
