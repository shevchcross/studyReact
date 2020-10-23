package studyReact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studyReact.exceptions.FilmNotFoundException;
import studyReact.models.Film;
import studyReact.repository.FilmRepository;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Film save(Film film) {
        filmRepository.saveAndFlush(film);
        return film;
    }

    public List<Film> findAll() {
        List<Film> films = filmRepository.findAll();
        return films;
    }

    public Film deleteFilm(String name) {
        Film filmById = filmRepository.findByName(name).orElse(new Film());
        filmRepository.delete(filmById);
        return filmById;
    }

    public Film findFilmByName(String name) throws FilmNotFoundException{
        Film filmByName = filmRepository.findByName(name).orElseThrow(() -> new FilmNotFoundException(name));
        return filmByName;
    }

    public HttpStatus deleteFilmById(Long id) {
        Film filmById = filmRepository.findById(id).orElse(null);
        filmRepository.delete(filmById);
        if (filmById != null) {
            return HttpStatus.NO_CONTENT;
        }
        return HttpStatus.NOT_FOUND;
    }


    public Film findFilmById(Long id) throws FilmNotFoundException {
        Film filmById = filmRepository.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
        return filmById;
    }

    @Transactional
    public void deleteAll() {
        filmRepository.deleteAll();
    }

    @Transactional
    public void  deleteSequence(){
        filmRepository.deleteSequence();
    };
}
