package pl.dentistryapp.dentistryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.dentistryapp.dentistryapp.model.Address;
import pl.dentistryapp.dentistryapp.model.Employee;
import pl.dentistryapp.dentistryapp.model.Pracownik;

import java.math.BigDecimal;
import java.sql.SQLOutput;

@SpringBootApplication
@EnableJpaRepositories(/*basePackageClasses = UserRepository.class*/)
public class DentistryappApplication {

    public static void main(String[] args) {


        SpringApplication.run(DentistryappApplication.class, args);

/*        Pracownik pracownik = new Pracownik();
        pracownik.setFirstName("Lukasz");
        pracownik.setLastName("Mlynarczyk");
        pracownik.setSalary(3200.3);

        System.out.println(pracownik);

        Pracownik pracownik2 = new Pracownik();
        pracownik2.setFirstName("Kinga");
        pracownik2.setLastName("Malec");
        pracownik2.setSalary(5000);
        pracownik2.setId(1);

        System.out.println(pracownik2);*/

/*        Pracownik pracownik3 = new Pracownik();
        pracownik3.setFirstName("didi");
        pracownik3.setLastName("didel");
        pracownik3.setSalary(1000);
        pracownik3.setId(2);
        pracownik3.setLocality("Szczecin");
        pracownik3.setZipCode("71-624");
        pracownik3.setStreet("kadlubka");
        pracownik3.setStreetNumber(42);

        System.out.println(pracownik3);*/

    }
}