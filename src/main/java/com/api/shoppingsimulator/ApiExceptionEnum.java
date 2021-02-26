package com.api.shoppingsimulator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ApiExceptionEnum {
    S0001("S0001","Error al validar el tipo de tarjeta: No coincide con la tarjeta registrada para el cliente", HttpStatus.BAD_REQUEST),
    S0002("S0002","Error al validar el numero de documento: No coincide con el número de documento registrado para el cliente", HttpStatus.BAD_REQUEST),
    S0003("S0003","Error al validar el producto: No cuenta con un producto asignado", HttpStatus.BAD_REQUEST);

    private String code;
    private String message;
    private HttpStatus status;

    public ApiException getException(){
        return ApiException.builder()
                .code(code)
                .message(message)
                .status(status)
                .build();
    }
}
