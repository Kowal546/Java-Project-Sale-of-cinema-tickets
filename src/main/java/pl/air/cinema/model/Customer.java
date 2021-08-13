package pl.air.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@AttributeOverride(column = @Column(name= "cus_id"), name = "id")
@NoArgsConstructor @Getter @Setter
public class Customer extends Human {


    @ManyToMany
    @JoinTable(
            name = "cus_tic",
            joinColumns = @JoinColumn(name = "cus_id", referencedColumnName = "cus_id"),
            inverseJoinColumns = @JoinColumn(name = "tic_id", referencedColumnName = "tic_id"))
    private List<Ticket> tickets = new ArrayList<>();



//    public void addTicket(Ticket ticket){
//        this.tickets.add(ticket);
//    }
}
