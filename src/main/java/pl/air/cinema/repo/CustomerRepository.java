package pl.air.cinema.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.air.cinema.model.Customer;


import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findAllByFirstNameAndLastName(String firstName, String lastName);

    Optional<Customer> deleteCustomerById(Long id);

}
