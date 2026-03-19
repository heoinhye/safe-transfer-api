package com.fintech.safetransferapi.service;

import com.fintech.safetransferapi.dto.TransferRequest;
import com.fintech.safetransferapi.dto.TransferResponse;
import com.fintech.safetransferapi.entity.Account;
import com.fintech.safetransferapi.entity.Transaction;
import com.fintech.safetransferapi.repository.AccountRepository;
import com.fintech.safetransferapi.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    /**
     * Execute a monty transfer between two accounts
     * */
    @Transactional // ensure atomicity: both withdrawal and deposit must succeed.
    public TransferResponse transferMoney(TransferRequest request){

        // 1. fetch accounts from DB
        Account sender = accountRepository.findById(request.getSenderId())
                .orElseThrow(() -> new IllegalArgumentException("Sender account not found with ID: " + request.getSenderId()));

        Account receiver = accountRepository.findById(request.getReceiverId())
                .orElseThrow(() -> new IllegalArgumentException("Receiver account not found with ID: " + request.getReceiverId()));

        // 2. Encapsulation. Rich Domain Model.
        sender.withdraw(request.getAmount());
        receiver.deposit(request.getAmount());

        // 3. save the audit log (transaction history)
        Transaction transaction = new Transaction(
                sender.getId(),
                receiver.getId(),
                request.getAmount()
        );
        transactionRepository.save(transaction);

        // 4. return the response DTO (receipt)
        return new TransferResponse(
                "Transfer has been completed successfully!",
                transaction.getId(),
                request.getAmount(),
                sender.getBalance()
        );
    }


}
