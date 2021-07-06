package com.example.customer_api.Customer;

import com.example.customer_api.Account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @SequenceGenerator(name = "customer_id_seq",sequenceName = "customer_id_seq",allocationSize = 1)
    @GeneratedValue(generator = "customer_id_seq",strategy = GenerationType.SEQUENCE)
    private Long customerId;

    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private String name;

    @Column(name = "email",columnDefinition = "TEXT",unique = true)
    private String email;

    @Column(name = "phone_number",nullable = false,columnDefinition = "TEXT",unique = true)
    private String phoneNumber;

    @Column(name = "date_of_birth",nullable = false,columnDefinition = "DATE")
    private Date dateOfBirth;

    @Column(name = "date_created",columnDefinition = "DATE")
    private Date dateCreated = new Date(System.currentTimeMillis());

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    private Set<Account> customer_accounts = new HashSet<>();

    public Customer() {
    }

    public Customer(String name, String email, String phoneNumber, Date dateOfBirth) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<Account> getCustomerAccounts() {
        return customer_accounts;
    }

    public void setCustomer_accounts(Set<Account> customer_accounts) {
        this.customer_accounts = customer_accounts;
    }

    public void notifyCustomerNewAccount(){

    }

    public void notifyCustomerUpdateInfo(){

    }
}
