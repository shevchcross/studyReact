package studyReact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studyReact.exceptions.CustomerNotFoundException;
import studyReact.models.Customer;
import studyReact.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.save(customer), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Customer> get(@PathVariable("id") Long id) throws CustomerNotFoundException {
        return new ResponseEntity<Customer>(customerService.getById(id), HttpStatus.OK);
    }

    @GetMapping(produces = {"application/json"})
    public List<Customer> getAll() {
        return customerService.findAll();
    }


    @DeleteMapping(value = "/{id}", produces = "application/json")
    public
    ResponseEntity deleteById(@PathVariable("id") Long id)  {
        return ResponseEntity.status(customerService.deleteById(id)).build();
    }
}
