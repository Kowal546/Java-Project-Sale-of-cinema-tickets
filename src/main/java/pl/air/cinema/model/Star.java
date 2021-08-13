package pl.air.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stars")
@AttributeOverride(column = @Column(name = "sta_id"), name = "id")
@NoArgsConstructor
@Getter
@Setter

public class Star extends Human{

    @ManyToMany
    @JoinTable(
            name = "mov_sta",
            joinColumns = @JoinColumn(name = "sta_id", referencedColumnName = "sta_id"),
            inverseJoinColumns = @JoinColumn(name = "mov_id", referencedColumnName = "mov_id"))
    private List<Movie> movies = new ArrayList<>();



}
