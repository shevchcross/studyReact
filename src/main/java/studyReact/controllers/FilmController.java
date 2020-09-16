package studyReact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studyReact.dto.TicketDTO;
import studyReact.models.FilmEntity;
import studyReact.services.FilmService;


@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;

    @RequestMapping(
            value = "/addfilm",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FilmEntity> createTicket(@RequestBody FilmEntity film) {
        FilmEntity savedTicketEntity = filmService.save(film);
        return new ResponseEntity<FilmEntity>(savedTicketEntity, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/getfilm/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FilmEntity> getTicket(@PathVariable("id") Long id) {
        FilmEntity film = filmService.getById(id);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FilmEntity>(film, HttpStatus.OK);
    }
}
