package com.example.customer_api.Account;

import com.example.customer_api.Customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Account")
public class Account {
    @Id
    @Column(name = "account_number")
    @SequenceGenerator(name = "account_number_seq",sequenceName = "account_number_seq",allocationSize = 1)
    @GeneratedValue(generator = "account_number_seq",strategy = GenerationType.SEQUENCE)
    private Long accountNumber;

    @Column(name = "current_balance", nullable = false)
    private Double currentBalance = 0.00;

    @Column(name = "opening_amount", nullable = false)
    private Double openingAmount = currentBalance;


    @Column(name = "date_created",nullable = false,columnDefinition = "DATE")
    private Date dateCreated = new Date(System.currentTimeMillis());

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    public Account() {
    }

    public Account(Double openingAmount) {
        this.openingAmount = openingAmount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", openingAmount=" + openingAmount +
                ", currentBalance=" + currentBalance +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getOpeningAmount() {
        return openingAmount;
    }

    public void setOpeningAmount(Double openingAmount) {
        this.openingAmount = openingAmount;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
