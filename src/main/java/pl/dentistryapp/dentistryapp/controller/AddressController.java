package pl.dentistryapp.dentistryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dentistryapp.dentistryapp.model.Address;
import pl.dentistryapp.dentistryapp.repository.AddressRepository;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
//@RequestMapping()
public class AddressController {

    @Autowired
    public AddressRepository addressRepository;

    //pobieranie wizyt
    @GetMapping(value = "addresses", produces = APPLICATION_JSON_VALUE)
    public @Valid Iterable<Address> getAddress() {
        return addressRepository.findAll();
    }

    //pobieranie wizity o id
    @GetMapping(value = "addresses/{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<Address> getAddress(@PathVariable Long id) {
//        return visitRepository.findByIdAndRefund(id, true);
        return addressRepository.findById(id);
    }

    //dodawanie wizyty
    @PostMapping(value = "addresses", produces = APPLICATION_JSON_VALUE)
    public @Valid Address addAddress(@Valid @RequestBody Address address) {
//        System.out.println(visit.getData());
        return addressRepository.save(address);
    }

    //usuwanie wizyty o id
    @DeleteMapping(value = "addresses/{id}", produces = APPLICATION_JSON_VALUE)
    public String deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
        return "Visit with id(" + id + ") was deleted";
    }

    //nadpisywanie pracownika (update)
    @PutMapping(value = "addresses", produces = APPLICATION_JSON_VALUE)
    public @Valid Address updateAddress(@Valid @RequestBody Address address) {
        return addressRepository.save(address);
    }
}
