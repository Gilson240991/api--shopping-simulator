package com.api.shoppingsimulator;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ApiException{
    private String code;
    private String message;
    private HttpStatus status;
}
