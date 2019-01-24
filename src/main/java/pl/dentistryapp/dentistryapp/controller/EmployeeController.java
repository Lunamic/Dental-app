package pl.dentistryapp.dentistryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dentistryapp.dentistryapp.model.Employee;
import pl.dentistryapp.dentistryapp.repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
//@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public EmployeeRepository employeeRepository;
    //na filmiku gosc ma private final..

    //pobieranie pracowników
    @GetMapping(value = "employees", produces = APPLICATION_JSON_VALUE)
    public Iterable<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    //pobieranie pracownika o id
    @GetMapping(value = "employees/{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    //dodawanie pracownika
    @PostMapping(value = "employees", produces = APPLICATION_JSON_VALUE)
    public String addEmployee(@Valid @RequestBody Employee employee) {
        int length = String.valueOf(employee.getPwz()).length();
        if (length==7) {
            employeeRepository.save(employee);
           return employeeRepository.save(employee).toString();
        }else{
            return "The PWZ number must have 7 digits";
        }
    }

    //usuwanie pracownika o id
    @DeleteMapping(value = "employees/{id}", produces = APPLICATION_JSON_VALUE)
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "employee with id("+id+") was deleted" ;
    }

    //nadpisywanie pracownika (update)
    @PutMapping(value = "employees", produces = APPLICATION_JSON_VALUE)
    public @Valid Employee updateEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}
