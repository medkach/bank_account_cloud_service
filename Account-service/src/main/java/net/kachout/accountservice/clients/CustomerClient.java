package net.kachout.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.kachout.accountservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClient {
@CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
@GetMapping("/customers/{id}")
Customer getCustomerById(@PathVariable Long id);
@GetMapping("/customers")
@CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultAllCustomers")
List<Customer> allCustomers();
default Customer getDefaultCustomer(Long id ,Exception e){
    Customer c=new Customer(id,"defaultName","defaultLastName","defaultEmail");
    return c;
}
default List<Customer> getDefaultAllCustomers(Exception e){
    return List.of();
}


}
