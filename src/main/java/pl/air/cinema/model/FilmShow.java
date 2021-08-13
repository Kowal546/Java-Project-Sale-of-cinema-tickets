package pl.air.cinema.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "film_shows")
@AttributeOverride(column = @Column(name = "fil_id"), name = "id")
@NoArgsConstructor
@Getter
@Setter

public class FilmShow extends BaseEntity {

    @NotNull
    @Column
    private LocalDate date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "mov_id")
    private Movie movie;


}
