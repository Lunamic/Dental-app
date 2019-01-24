package pl.dentistryapp.dentistryapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dentistryapp.dentistryapp.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}