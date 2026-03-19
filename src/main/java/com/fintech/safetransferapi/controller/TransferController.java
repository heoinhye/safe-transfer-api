package com.fintech.safetransferapi.controller;

import com.fintech.safetransferapi.dto.TransferRequest;
import com.fintech.safetransferapi.dto.TransferResponse;
import com.fintech.safetransferapi.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    /**
     * Endpoint for initiating a money transfer between two accounts.
     * @param request The transfer details (sender, receiver, amount)
     * @return A response containing the transaction summary
     * */
    @PostMapping
    public ResponseEntity<TransferResponse> transfer(@RequestBody TransferRequest request){
        TransferResponse response = transferService.transferMoney(request);
        return ResponseEntity.ok(response);
    }
}
