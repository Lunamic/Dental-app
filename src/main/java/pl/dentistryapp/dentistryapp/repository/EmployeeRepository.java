package pl.dentistryapp.dentistryapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dentistryapp.dentistryapp.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{


/*    public List<User> findByDone(Boolean done);

    @Query("select t from User t where t.description like %?1%")
    public List<User> getByDescriptionLike(String search);*/
}