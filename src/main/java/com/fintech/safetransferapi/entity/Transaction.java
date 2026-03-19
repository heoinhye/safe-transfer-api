package com.fintech.safetransferapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderAccountId; // the money is coming from

    private Long receiverAccountId; // the money is going to

    @Column(precision = 19, scale = 4)
    private BigDecimal amount; // use BigDecimal to ensure no precision loss in financial records

    private LocalDateTime createdAt;

    public Transaction(Long senderAccountId, Long receiverAccountId, BigDecimal amount){
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.amount = amount;
        this.createdAt = LocalDateTime.now(); // automatically set the timestamp
    }

}
