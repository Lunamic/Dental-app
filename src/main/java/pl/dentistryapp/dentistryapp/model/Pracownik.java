package pl.dentistryapp.dentistryapp.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
//@Table(name = "Pracownicy")
//@SecondaryTable(name = "Adresy", pkJoinColumns = @PrimaryKeyJoinColumn(name = "pracownicyId"))
public class Pracownik {


    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "imie", nullable = false, length = 10)
    private String firstName;
    @Column(name = "nazwisko")
    private String lastName;
    @Column(name = "pensja")
    private double salary;

//    @Embedded
    @OneToOne
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}
