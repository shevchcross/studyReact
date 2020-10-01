package studyReact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studyReact.exceptions.HallNotFoundException;
import studyReact.models.Hall;
import studyReact.services.HallService;

import java.util.List;

@RestController
@RequestMapping("/halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Hall> create(@RequestBody Hall hall) {
        return new ResponseEntity<Hall>(hallService.save(hall), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Hall> get(@PathVariable("id") Long id) {
        return new ResponseEntity<Hall>(hallService.getById(id), HttpStatus.OK);
    }

    @GetMapping(produces = {"application/json"})
    public List<Hall> getAll() {
        return hallService.findAll();
    }

    @GetMapping(value = "/byId/{id}", produces = {"application/json"})
    public
    @ResponseBody
    Hall halldById(@PathVariable("id") Long id) throws HallNotFoundException {
        Hall halldById = hallService.halldById(id);
        return halldById;
    }

//    @GetMapping(value = "/byname/{name}", produces = {"application/json"})
//    public
//    @ResponseBody
//    Hall findByName(@PathVariable("name") String name) throws HallNotFoundException {
//        Hall hallByName = hallService.findHallByName(name);
//        return hallByName;
//    }


    @DeleteMapping(value = "/{id}", produces = "application/json")
    public
    @ResponseBody
    Hall delete(@PathVariable("id") Long id) throws HallNotFoundException {
        return hallService.delete(id);
    }


}
