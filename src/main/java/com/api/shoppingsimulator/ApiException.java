package com.api.shoppingsimulator;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiException{
    private String code;
    private String message;
    private HttpStatus status;
    private List<ApiException> errors;
}
