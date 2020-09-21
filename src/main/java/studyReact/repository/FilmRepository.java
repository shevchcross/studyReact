package studyReact.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import studyReact.models.Film;


public interface FilmRepository extends JpaRepository<Film, Long> {
}
