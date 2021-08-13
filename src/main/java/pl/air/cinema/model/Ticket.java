package pl.air.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tickets")
@AttributeOverride(column = @Column(name = "tic_id"), name = "id")
@NoArgsConstructor
@Getter
@Setter
public class Ticket extends BaseEntity {
    @NotNull
    @Column
    private boolean reduction;

    @NotNull
    @Column
    private double price;

    @NotNull
    @Column
    private int seat;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "fil_id")
    private FilmShow filmShow;

    @ManyToMany
    @JoinTable(
            name = "cus_tic",
            joinColumns = @JoinColumn(name = "tic_id", referencedColumnName = "tic_id"),
            inverseJoinColumns = @JoinColumn(name = "cus_id", referencedColumnName = "cus_id"))
    private List<Customer> customers = new ArrayList<>();



    public void setPrice(double price) {
        if (this.reduction == true) {
            this.price = price * 0.5;
        } else {
            this.price = price;
        }
    }

}
