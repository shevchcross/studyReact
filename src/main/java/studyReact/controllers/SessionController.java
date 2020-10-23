package studyReact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studyReact.exceptions.CustomerNotFoundException;
import studyReact.exceptions.SessionNotFoundException;
import studyReact.models.Session;
import studyReact.services.SessionService;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Session> create(@RequestBody Session session) {
        return new ResponseEntity<Session>(sessionService.save(session), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Session> get(@PathVariable("id") Long id) throws SessionNotFoundException {
        return new ResponseEntity<Session>(sessionService.getById(id), HttpStatus.OK);
    }

    @GetMapping(produces = {"application/json"})
    public List<Session> getAll() {
        return sessionService.findAll();
    }


    @DeleteMapping(value = "/{id}", produces = "application/json")
    public
    ResponseEntity deleteById(@PathVariable("id") Long id)  {
        return ResponseEntity.status(sessionService.deleteById(id)).build();
    }

}
