package com.fintech.safetransferapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class TransferRequest {

    private Long senderId;
    private Long receiverId;
    private BigDecimal amount;

    // for testing
    public TransferRequest(Long senderId, Long receiverId, BigDecimal amount){
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
    }

}
