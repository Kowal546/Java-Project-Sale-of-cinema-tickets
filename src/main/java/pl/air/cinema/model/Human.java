package pl.air.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@AttributeOverride(column = @Column(name = "hum_id"), name = "id")
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass


public abstract class  Human extends BaseEntity {

    @NotBlank
    @Size(max = 30)
    @Column(name = "first_name", nullable = false)
    protected String firstName;

    @NotBlank
    @Size(max = 50)
    @Column(name = "last_name", nullable = false)
    protected String lastName;


    @Column(name = "birth_date")
    protected LocalDate birthDate;

}
