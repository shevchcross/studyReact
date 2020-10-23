package studyReact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studyReact.exceptions.FilmNotFoundException;
import studyReact.models.Film;
import studyReact.services.FilmService;

import java.util.List;


@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        return new ResponseEntity<Film>(filmService.save(film), HttpStatus.CREATED);
    }


    @GetMapping(produces = {"application/json"})
    public List<Film> getAllFilms() {
        return filmService.findAll();
    }

    @DeleteMapping(value = "/name/{name}", produces = "application/json")
    public
    @ResponseBody
    Film delete(@PathVariable("name") String name) throws FilmNotFoundException {
        return filmService.deleteFilm(name);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public
    ResponseEntity deleteById(@PathVariable("id") Long id)  {
        return ResponseEntity.status(filmService.deleteFilmById(id)).build();
    }

    @GetMapping(value = "/name/{name}", produces = {"application/json"})
    public
    @ResponseBody
    Film findFilmByName(@PathVariable("name") String name) throws FilmNotFoundException {
        Film filmByName = filmService.findFilmByName(name);
        return filmByName;
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public
    @ResponseBody
    Film findFilmById(@PathVariable("id") Long id) throws FilmNotFoundException {
        Film filmById = filmService.findFilmById(id);
        return filmById;
    }


}
