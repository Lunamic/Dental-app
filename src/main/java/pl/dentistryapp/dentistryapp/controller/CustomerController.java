package pl.dentistryapp.dentistryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dentistryapp.dentistryapp.model.Customer;
import pl.dentistryapp.dentistryapp.repository.CustomerRepository;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
public class CustomerController {

    @Autowired
    public CustomerRepository customerRepository;

    @GetMapping(value = "customers", produces = APPLICATION_JSON_VALUE)
    public @Valid Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(value = "customers/{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<Customer> getCustomers(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @PostMapping(value = "customers", produces = APPLICATION_JSON_VALUE)
    public @Valid Customer addCustomers(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping(value = "customers/{id}", produces = APPLICATION_JSON_VALUE)
    public String deleteCustomers(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return "Visit with id(" + id + ") was deleted";
    }

    @PutMapping(value = "customers", produces = APPLICATION_JSON_VALUE)
    public @Valid Customer updateCustomers(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}
