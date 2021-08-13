package pl.air.cinema.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.air.cinema.model.Customer;
import pl.air.cinema.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

List<Ticket> findAllByCustomers(Customer customer);
Optional<Ticket> deleteTicketById(Long id);
}
