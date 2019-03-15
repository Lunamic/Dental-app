package pl.dentistryapp.dentistryapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Embeddable
@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String locality;
    @Column
    private String zipCode;
    @Column
    private String street;
    @Column
    private int streetNumber;

//    @OneToMany(mappedBy = "address", cascade = {CascadeType.MERGE})
//    private List<Customer> customerList;

/*    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "owner_id")
    private Customer customer;*/


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

}
