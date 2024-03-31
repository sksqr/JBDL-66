package com.gfg;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TxnCompletedPayload {
    private Long id;
    private Boolean success;
    private String reason;
    private String requestId;
}
