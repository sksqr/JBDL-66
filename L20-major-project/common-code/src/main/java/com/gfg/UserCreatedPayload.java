package com.gfg;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserCreatedPayload {
    private Long userId;
    private String userName;
    private String userEmail;
    private String requestId;
}
