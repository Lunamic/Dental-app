package pl.dentistryapp.dentistryapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long UserId;

    @NotNull
    @Size(min = 2, max = 20)
    @Column
    private String name;

    @NotNull
    @Size(min = 2, max = 20)
    @Column
    private String surname;

    @PESEL
    @Column
    private String pesel;

    @NotNull
    @Column
    private Integer phone;

    @Email
    @Column
    private String email;

    @Column
    private String town;

    @Column
    private String adress;

    @Column
    @Lob
    private String description;

    public User(@NotNull @Size(min = 2, max = 20) String name, @NotNull @Size(min = 2, max = 20) String surname, @PESEL String pesel, @NotNull Integer phone, @Email String email, String town, String adress, String description) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.phone = phone;
        this.email = email;
        this.town = town;
        this.adress = adress;
        this.description = description;
    }
}
