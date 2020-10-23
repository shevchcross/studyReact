package studyReact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import studyReact.exceptions.CustomerNotFoundException;
import studyReact.models.Customer;
import studyReact.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer save(Customer customer) {
        repository.save(customer);
        return customer;
    }

    public Customer getById(Long id) throws CustomerNotFoundException {
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        return customer;
    }

    public List<Customer> findAll() {
        List<Customer> customer = repository.findAll();
        return customer;
    }

    public HttpStatus deleteById(Long id) {
        Customer customer = repository.findById(id).orElse(null);
        repository.delete(customer);
        if (customer != null) {
            return HttpStatus.NO_CONTENT;
        }
        return HttpStatus.NOT_FOUND;
    }

}
