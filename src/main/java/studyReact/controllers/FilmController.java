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

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Film> getFilm(@PathVariable("id") Long id) {
        return new ResponseEntity<Film>(filmService.getById(id), HttpStatus.OK);
    }

    @GetMapping( produces = {"application/json"} )
    public List<Film> getAllFilms() {
        return filmService.findAll();
    }

    @DeleteMapping(value = "/{name}", produces = "application/json")
    public
    @ResponseBody
    Film deleteFilm(@PathVariable("name") String name) throws FilmNotFoundException {
        return filmService.deleteFilm(name);
    }

    @GetMapping(value = "/byname/{name}", produces = {"application/json"})
    public
    @ResponseBody
    Film findFilmByName(@PathVariable("name") String name) throws FilmNotFoundException {
        Film filmByName = filmService.findFilmByName(name);
        return filmByName;
    }


}
