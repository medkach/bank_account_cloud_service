package net.kachout.accountservice.entity;

import jakarta.persistence.*;
import lombok.*;
import net.kachout.accountservice.enums.AccountType;
import net.kachout.accountservice.models.Customer;

import java.time.LocalDate;

@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long customerId;
    @Transient
    private Customer customer;
}
