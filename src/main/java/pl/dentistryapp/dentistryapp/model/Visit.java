package pl.dentistryapp.dentistryapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class Visit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    @NotNull
    private String data;

    @Column
    @Lob
    private String description;

    @Column
    private Boolean refund;

    public Visit(@NotNull String data, String description, Boolean refund) {
        this.data = data;
        this.description = description;
        this.refund = refund;
    }
}
