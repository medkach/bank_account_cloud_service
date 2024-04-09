package net.kachout.customerservice.repository;

import net.kachout.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public Optional<Customer> findByEmail(String email);
    List<Customer> findByFirstNameContainsIgnoreCase(String name);
}
