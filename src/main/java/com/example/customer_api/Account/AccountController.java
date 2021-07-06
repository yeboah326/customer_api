package com.example.customer_api.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    public AccountService accountService;

    @GetMapping(value = "/accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping(value = "/accounts/email/{email}")
    public List<Account> getAccountsByEmail(@PathVariable String email){
        return accountService.getAccountsByEmail(email);
    }

    @GetMapping(value = "/accounts/phoneNumber/{phoneNumber}")
    public List<Account> getAccountsByPhoneNumber(@PathVariable String phoneNumber){
        return accountService.getAccountsByPhoneNumber(phoneNumber);
    }

    @PostMapping(value = "/accounts/new/{customerId}")
    public Account createNewAccount(@RequestBody Account new_account, @PathVariable Long customerId){
        return accountService.createNewAccount(new_account, customerId);
    }

    @DeleteMapping(value = "/accounts/{accountNumber}")
    public void deleteAccount(@PathVariable Long accountNumber){
        accountService.deleteAccount(accountNumber);
    }

}
