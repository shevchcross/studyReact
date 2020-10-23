package studyReact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studyReact.exceptions.HallNotFoundException;
import studyReact.exceptions.SeatNotFoundException;
import studyReact.models.Seat;
import studyReact.services.SeatService;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Seat> create(@RequestBody Seat hall) {
        return new ResponseEntity<Seat>(seatService.save(hall), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Seat> get(@PathVariable("id") Long id) throws SeatNotFoundException {
        return new ResponseEntity<Seat>(seatService.getById(id), HttpStatus.OK);
    }

    @GetMapping(produces = {"application/json"})
    public List<Seat> getAll() {
        return seatService.findAll();
    }


    @DeleteMapping(value = "/{id}", produces = "application/json")
    public
    @ResponseBody
    ResponseEntity delete(@PathVariable("id") Long id) throws  SeatNotFoundException {
        return ResponseEntity.status(seatService.delete(id)).build();
    }
}
