package com.example.L20paymentgatewaydemo.controller;

import com.example.L20paymentgatewaydemo.dto.PaymentInitResponse;
import com.example.L20paymentgatewaydemo.dto.PaymentPageRequest;
import com.example.L20paymentgatewaydemo.dto.TransactionDetailDto;
import com.example.L20paymentgatewaydemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/pg-service")
public class PGController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/payment-status/{txnId}")
    ResponseEntity<TransactionDetailDto> getStatus(@PathVariable String txnId){
        return ResponseEntity.ok(transactionService.getStatus(txnId));
    }

    /*
    making all transaction successful.
     */
    @PostMapping("/doPayment/{txnId}")
    ResponseEntity<String> doPayment(@PathVariable String txnId) throws URISyntaxException {
        String url = transactionService.doPaymentAndRedirect(txnId);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @PostMapping("/init-payment")
    ResponseEntity<PaymentInitResponse> initPayment(@RequestBody PaymentPageRequest pageRequest) throws URISyntaxException {
        PaymentInitResponse response = transactionService.generatePaymentPage(pageRequest);
        return ResponseEntity.ok(response);
    }




}
