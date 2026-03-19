package com.fintech.safetransferapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class TransferResponse {

    private String message;
    private Long transactionId;
    private BigDecimal amountSent;
    private BigDecimal remainingBalance;

}
