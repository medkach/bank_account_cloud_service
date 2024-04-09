package net.kachout.accountservice;

import net.kachout.accountservice.clients.CustomerClient;
import net.kachout.accountservice.entity.Account;
import net.kachout.accountservice.enums.AccountType;
import net.kachout.accountservice.models.Customer;
import net.kachout.accountservice.repository.AccountRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    ApplicationRunner run(AccountRepository accountRepository, CustomerClient customerClient)
    {
        return args -> {
            customerClient.allCustomers().forEach(
                    c->{
                        Account a1= Account
                                .builder()
                                .accountType(AccountType.CURRENT_ACCOUNT)
                                .balance(100000)
                                .createAt(LocalDate.now())
                                .currency("DTN")
                                .customerId(c.id())
                                .build();
                        Account a2= Account
                                .builder()
                                .accountType(AccountType.SAVING_ACCOUNT)
                                .balance(200000)
                                .createAt(LocalDate.now())
                                .currency("DTN")
                                .customerId(c.id())
                                .build();
                        accountRepository.saveAll(List.of(a1,a2));
                    }
            );

        };
    }

}
