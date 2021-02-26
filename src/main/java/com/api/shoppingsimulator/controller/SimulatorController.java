package com.api.shoppingsimulator.controller;

import com.api.shoppingsimulator.ApiException;
import com.api.shoppingsimulator.api.request.SimulatorRequest;
import com.api.shoppingsimulator.api.response.SimulatorResponse;
import com.api.shoppingsimulator.service.SimulatorService;
import com.api.shoppingsimulator.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("simulators")
public class SimulatorController {

    @Autowired
    private SimulatorService service;

    @PostMapping(value = "/getPayment")
    public ResponseEntity<Response<SimulatorResponse>> getDebtToPay(@Valid @RequestBody SimulatorRequest simulatorRequest, BindingResult result){
        Response<SimulatorResponse> response = new Response<>();
        List<ApiException> listErrors = new ArrayList<>();
        if(result.hasErrors()){
            for(FieldError err : result.getFieldErrors()){

               listErrors.add(ApiException.builder().code(err.getField()).message(err.getDefaultMessage()).build());

            }
            response.setException(ApiException.builder().errors(listErrors).build() );
            return ResponseEntity.badRequest().body(response);
        }

        response = service.getPayment(simulatorRequest);

        if(!Objects.isNull(response.getException()) && response.getException().getStatus().equals(HttpStatus.BAD_REQUEST)){
                return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(service.getPayment(simulatorRequest));
    }
}
