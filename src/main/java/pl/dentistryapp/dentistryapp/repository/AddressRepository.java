package pl.dentistryapp.dentistryapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dentistryapp.dentistryapp.model.Address;
import pl.dentistryapp.dentistryapp.model.Pracownik;

public interface AddressRepository extends CrudRepository<Address, Long>{

}