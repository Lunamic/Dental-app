package pl.dentistryapp.dentistryapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dentistryapp.dentistryapp.model.User;
import pl.dentistryapp.dentistryapp.model.Visit;

import java.util.Optional;

public interface VisitRepository extends CrudRepository<Visit, Long> {

    Optional<Visit> findByIdAndRefund(Long visitId, boolean refund);

/*    public List<User> findByDone(Boolean done);

    @Query("select t from User t where t.description like %?1%")
    public List<User> getByDescriptionLike(String search);*/
}