package pl.dentistryapp.dentistryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dentistryapp.dentistryapp.model.Visit;
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

    //dodawanie wizyty
    @PostMapping(value = "visits", produces = APPLICATION_JSON_VALUE)
    public @Valid Visit addVisit(@Valid @RequestBody Visit visit) {
        System.out.println(visit.getData());
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
