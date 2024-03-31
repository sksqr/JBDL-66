package com.example.L20paymentgatewaydemo.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentPageRequest {

    private Long merchantId;

    private Double amount;

    private Long userId;

}
