package com.api.shoppingsimulator.util;

import com.api.shoppingsimulator.ApiException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T>{
    private T result;
    private ApiException exception;

}
