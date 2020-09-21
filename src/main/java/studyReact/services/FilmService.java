package studyReact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studyReact.models.Film;
import studyReact.repository.FilmRepository;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Film save(Film film) {
        filmRepository.save(film);
        return film;
    }


    public Film getById(Long id) {
        Film film = filmRepository.findById(id).orElse(new Film());
        return film;
    }

    public List<Film> findAll() {
        List<Film> productEntities = filmRepository.findAll();
        return productEntities;
    }
}
