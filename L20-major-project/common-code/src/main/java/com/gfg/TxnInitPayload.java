package com.gfg;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class TxnInitPayload {

    private Long id;
    private Long fromUserId;
    private Long toUserId;
    private Double amount;
    private String requestId;
}
