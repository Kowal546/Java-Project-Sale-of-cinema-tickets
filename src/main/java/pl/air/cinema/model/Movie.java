package pl.air.cinema.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@AttributeOverride(column = @Column(name = "mov_id"), name = "id")
@NoArgsConstructor
@Getter
@Setter

public class Movie extends BaseEntity {
    @NotNull
    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "dir_id")
    private Director director;


    @ManyToMany
    @JoinTable(
            name = "mov_sta",
            joinColumns = @JoinColumn(name = "mov_id", referencedColumnName = "mov_id"),
            inverseJoinColumns = @JoinColumn(name = "sta_id", referencedColumnName = "sta_id"))
    private List<Star> stars = new ArrayList<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pro_id")
    private ProductionCompany productionCompany;


}
