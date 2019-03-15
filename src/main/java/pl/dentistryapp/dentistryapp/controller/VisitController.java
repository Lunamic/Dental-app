package pl.dentistryapp.dentistryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dentistryapp.dentistryapp.model.Customer;
import pl.dentistryapp.dentistryapp.model.Employee;
import pl.dentistryapp.dentistryapp.model.Visit;
import pl.dentistryapp.dentistryapp.repository.CustomerRepository;
import pl.dentistryapp.dentistryapp.repository.EmployeeRepository;
import pl.dentistryapp.dentistryapp.repository.VisitRepository;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
//@RequestMapping("visit")
//@RequestMapping
public class VisitController {

    @Autowired
    public VisitRepository visitRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public EmployeeRepository  employeeRepository;

    //pobieranie wizyt
    @GetMapping(value = "visits", produces = APPLICATION_JSON_VALUE)
    public @Valid Iterable<Visit> getVisit() {
        return visitRepository.findAll();
    }

    //pobieranie wizity o id
    @GetMapping(value = "visits/{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<Visit> getVisit(@PathVariable Long id) {
//        return visitRepository.findByIdAndRefund(id, true);
        return visitRepository.findById(id);
    }

/*    //dodawanie wizyty
    @PostMapping(value = "visits", produces = APPLICATION_JSON_VALUE)
    public @Valid Visit addVisit(@Valid @RequestBody Visit visit) {
        System.out.println(visit.getData());
        return visitRepository.save(visit);
    }*/

    //dodawanie wizyty
    @PostMapping(value = "visits", produces = APPLICATION_JSON_VALUE)
    public @Valid Visit addVisit(@Valid @RequestBody Visit visit) {
//        System.out.println(visit.getData());
//        visit.getCustomerList()
        System.out.println(visit.getCustomerId());
//        Optional<Customer> customerId = customerRepository.findById(visit.getCustomer().getId());
//        System.out.println(customerId);
//        visit.setCustomer(visit.getCustomer().);

/*        Optional<Customer> customerRepositoryById = customerRepository.findById(visit.getCustomerId());

        visit.getCustomer().setFirstName(customerRepositoryById.get().getFirstName());
        visit.getCustomer().setLastName(customerRepositoryById.get().getLastName());
        visit.getCustomer().setPesel(customerRepositoryById.get().getPesel());
        visit.getCustomer().setPhone(customerRepositoryById.get().getPhone());
        visit.getCustomer().setEmail(customerRepositoryById.get().getEmail());
        visit.getCustomer().setDescription(customerRepositoryById.get().getDescription());
        visit.getCustomer().setId(customerRepositoryById.get().getId());*/

//        visit.getCustomer()
        Optional<Customer> customerRepositoryById = customerRepository.findById(visit.getCustomerId());
        Optional<Employee> employeeRepositoryById = employeeRepository.findById(visit.getEmployeeId());

        System.out.println(visit);
        System.out.println(customerRepositoryById);
        System.out.println(employeeRepositoryById);
        return visitRepository.save(visit);
    }

    //usuwanie wizyty o id
    @DeleteMapping(value = "visits/{id}", produces = APPLICATION_JSON_VALUE)
    public String deleteVisit(@PathVariable Long id) {
        visitRepository.deleteById(id);
        return "Visit with id("+id+") was deleted" ;
    }

    //nadpisywanie pracownika (update)
    @PutMapping(value = "visits", produces = APPLICATION_JSON_VALUE)
    public @Valid Visit updateEmployee(@Valid @RequestBody Visit visit) {
        return visitRepository.save(visit);
    }
}
