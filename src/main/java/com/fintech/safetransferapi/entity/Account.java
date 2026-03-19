package com.fintech.safetransferapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;

    @Column(precision = 19, scale = 4)
    private BigDecimal balance; // use BigDecimal for high precision in financial data

    @Version //Optimistic Locking to handle concurrent transactions
    private Long version;

    public Account(String ownerName, BigDecimal balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    /**
     * deducts the specified amount from the balance.
     * @param amount The amount to withdraw
     * @throws IllegalArgumentException if the balance is insufficient
     * */
    public void withdraw(BigDecimal amount){
        if(this.balance.compareTo(amount)<0){
            throw new RuntimeException("Insufficient balance for account ID: " + this.id);
        }
        this.balance = this.balance.subtract(amount);
    }

    /**
     * adds the specified amount to the balance.
     * @param amount The amount to deposit
     * */
    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

}
