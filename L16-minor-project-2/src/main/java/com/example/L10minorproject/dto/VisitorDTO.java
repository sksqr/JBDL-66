package com.example.L10minorproject.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitorDTO {

    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 10)
    private String phone;

    @NotNull
    @Size(max = 255)
    private String idNumber;

    private AddressDto address;


}
