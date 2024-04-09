package net.kachout.customerservice.web;

import net.kachout.customerservice.entity.Customer;
import net.kachout.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
    private final CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    public List<Customer> getAllCustomer()
    {
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("customer not exist"));

    }
}
