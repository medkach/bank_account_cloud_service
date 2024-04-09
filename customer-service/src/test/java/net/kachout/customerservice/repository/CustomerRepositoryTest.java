package net.kachout.customerservice.repository;

import net.kachout.customerservice.entity.Customer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("test")
class CustomerRepositoryTest {
@Autowired
    private CustomerRepository customerRepository;
@BeforeEach
public void setUp()
{
    Customer c1= Customer
            .builder()
            .firstName("ali")
            .LastName("ben ali")
            .email("ali@gmail.com")
            .build();
    Customer c2= Customer
            .builder()
            .firstName("ahmed")
            .LastName("ben ahmed")
            .email("ahmed@gmail.com")
            .build();
    Customer c3= Customer
            .builder()
            .firstName("hajer")
            .LastName("ben hsin")
            .email("hajer@gmail.com")
            .build();
    List<Customer> customers = customerRepository.saveAll(List.of(c1, c2));

}
@Test
public void shouldBeFindCustomerByEmail(){
    String givenEmail="hajer@gmail.com";
    Optional<Customer> result = customerRepository.findByEmail(givenEmail);
    assertThat(result).isPresent();

}
public void should()
{
    String keyWord="e";
    List<Customer> expected=List.of(Customer
            .builder()
            .firstName("hajer")
            .LastName("ben hsin")
            .email("hajer@gmail.com")
            .build(),Customer
            .builder()
            .firstName("ahmed")
            .LastName("ben ahmed")
            .email("ahmed@gmail.com")
            .build());
    List<Customer> result=customerRepository.findByFirstNameContainsIgnoreCase("e");
    assertThat(result).isNotNull();
    assertThat(result.size()).isEqualTo(2);
}
}