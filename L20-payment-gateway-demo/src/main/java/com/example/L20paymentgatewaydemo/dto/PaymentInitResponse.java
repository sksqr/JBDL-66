package com.example.L20paymentgatewaydemo.dto;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInitResponse {
    private String url;
    private String txnId;
}
