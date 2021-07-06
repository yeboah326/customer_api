package com.example.customer_api.Account;

import com.example.customer_api.Customer.Customer;
import com.example.customer_api.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    public AccountRepository accountRepository;

    @Autowired
    public CustomerRepository customerRepository;

    public List<Account> getAllAccounts() {
      return accountRepository.findAll();
    }

    public List<Account> getAccountsByEmail(String email) {
        return accountRepository.findAll();
    }

    public List<Account> getAccountsByPhoneNumber(String phoneNumber) {
        return accountRepository.findAll();
    }

    public Account createNewAccount(Account new_account,Long customerId) {
        Customer current_customer = customerRepository.findById(customerId).get();
        new_account.setCustomer(current_customer);
        return accountRepository.save(new_account);
    }

    public void deleteAccount(Long accountNumber) {
        Account current_account = accountRepository.getById(accountNumber);
        accountRepository.deleteById(accountNumber);
    }

}
