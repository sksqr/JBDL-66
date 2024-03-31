package com.gfg.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserDto {

    @NotNull
    private String name;


    @NotNull
    private String email;


    @NotNull
    private String phone;


    @NotNull
    private String kycNumber;
}
