package net.kachout.accountservice.web;

import net.kachout.accountservice.clients.CustomerClient;
import net.kachout.accountservice.entity.Account;
import net.kachout.accountservice.models.Customer;
import net.kachout.accountservice.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private final AccountRepository accountRepository;
    private final CustomerClient customerClient;

    public AccountRestController(AccountRepository accountRepository, CustomerClient customerClient) {
        this.accountRepository = accountRepository;
        this.customerClient = customerClient;
    }
    @GetMapping("/accounts")
    public List<Account> getAllAccount()
    {
        List<Account> all = accountRepository.findAll();
        all.forEach(account -> {
            Customer customerById = customerClient.getCustomerById(account.getId());
            account.setCustomer(customerById);
        });
        return all;
    }
    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable Long id)
    {
        Account account = accountRepository.findById(id).get();
        Customer c=customerClient.getCustomerById(account.getCustomerId());
        account.setCustomer(c);
        return account;
    }
}
