package com.example.customer_api.Customer;

import com.example.customer_api.Account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CustomerController {
    @Autowired
    public CustomerService customerService;

//    Get all customers
    @GetMapping(value = "/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

//    Get customer by email
    @GetMapping(value = "/customers/email/{email}")
    public Customer getCustomerByEmail(@PathVariable String email){
        return customerService.getCustomerByEmail(email);
    }

//    Get customer by phone number
    @GetMapping(value = "/customers/phoneNumber/{phoneNumber}")
    public Customer getCustomerByPhoneNumber(@PathVariable String phoneNumber){
        return customerService.getCustomerByPhoneNumber(phoneNumber);
    }

//    Get customer accounts by email
    @GetMapping(value = "/customers/email/{email}/accounts")
    public Set<Account> getCustomerAccountsByEmail(@PathVariable String email){
        return customerService.getCustomerAccountsByEmail(email);
    }

//    Get customer accounts by phone number
    @GetMapping(value = "/customers/phoneNumber/{phoneNumber}/accounts")
    public Set<Account> getCustomerAccountsByPhoneNumber(@PathVariable String phoneNumber){
        return customerService.getCustomerAccountsByPhoneNumber(phoneNumber);
    }

//    Create a new customer
    @PostMapping(value = "/customers")
    public void addNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

//    Update Customer Info
    @PutMapping(value = "/customers/phoneNumber/{phoneNumber}")
    public void updateCustomerInfo(@RequestBody Customer customer,@PathVariable String phoneNumber){
        customerService.updateCustomerInfo(customer, phoneNumber);
    }

//    Delete customer
    @DeleteMapping(value = "/customers/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);
    }
}
