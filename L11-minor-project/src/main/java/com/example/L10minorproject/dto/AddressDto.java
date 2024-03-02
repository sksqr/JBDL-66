package com.example.L10minorproject.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AddressDto {

    @NotNull
    @Size(max = 255)
    private String line1;

    @Size(max = 255)
    private String line2;

    @Size(max = 255)
    private String pincode;

    @NotNull
    @Size(max = 255)
    private String city;

    @Size(max = 255)
    private String country;
}
