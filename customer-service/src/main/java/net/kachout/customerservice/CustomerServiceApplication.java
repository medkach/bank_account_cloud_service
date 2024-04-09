package net.kachout.customerservice;

import net.kachout.customerservice.config.GlobalConfig;
import net.kachout.customerservice.entity.Customer;
import net.kachout.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    @Profile("!test")
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return  args -> {
            System.out.println("customer serrrrrrrrrviiiiiicessssssssss");
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
            customers.forEach(System.out::println);
        };
    }
}
