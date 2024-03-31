package com.gfg;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddMoneyRequest {
    private Long merchantId;
    private Double amount;
    private Long userId;
}
