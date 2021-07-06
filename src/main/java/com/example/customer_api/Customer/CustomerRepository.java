package com.example.customer_api.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public Customer findByEmail(String email);
    public Customer findByPhoneNumber(String phoneNumber);
}
