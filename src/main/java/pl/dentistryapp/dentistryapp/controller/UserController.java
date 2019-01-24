package pl.dentistryapp.dentistryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dentistryapp.dentistryapp.model.User;
import pl.dentistryapp.dentistryapp.repository.UserRepository;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserRepository userRepository;
    //na filmiku gosc ma private final..


    //pobieranie uzytkownikow
    @GetMapping(value = "users", produces = APPLICATION_JSON_VALUE)
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    //pobieranie uzytkownika o id
    @GetMapping(value = "users/{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    //dodawanie uzytkownika
    @PostMapping(value = "users", produces = APPLICATION_JSON_VALUE)
    public User addUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    //usuwanie uzytkownika o id
    @DeleteMapping(value = "users/{id}", produces = APPLICATION_JSON_VALUE)
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "user with id("+id+") was deleted" ;
    }

    //nadpisywanie uzytkownika (update)
    @PutMapping(value = "users", produces = APPLICATION_JSON_VALUE)
    public @Valid User updateUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }
}
