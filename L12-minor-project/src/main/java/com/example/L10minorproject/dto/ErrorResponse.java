package com.example.L10minorproject.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
    private Integer httpStatus;
    private String exception;
    private String message;
}
