package com.example.customer_api.Customer;

import com.example.customer_api.Account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerService {
    @Autowired
    public CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer getCustomerByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    public void updateCustomerInfo(Customer customer , String phoneNumber) {
        customerRepository.save(customer);
    }

    public Set<Account> getCustomerAccountsByEmail(String email) {
        Customer current_customer = getCustomerByEmail(email);
        return current_customer.getCustomerAccounts();
    }

    public Set<Account> getCustomerAccountsByPhoneNumber(String phoneNumber) {
        Customer current_customer = getCustomerByPhoneNumber(phoneNumber);
        return current_customer.getCustomerAccounts();
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
