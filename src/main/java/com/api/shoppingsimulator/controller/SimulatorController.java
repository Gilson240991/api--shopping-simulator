package com.api.shoppingsimulator.controller;

import com.api.shoppingsimulator.api.request.SimulatorRequest;
import com.api.shoppingsimulator.api.response.SimulatorResponse;
import com.api.shoppingsimulator.service.SimulatorService;
import com.api.shoppingsimulator.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("simulators")
public class SimulatorController {

    @Autowired
    private SimulatorService service;

    @PostMapping(value = "/getPayment", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Response<SimulatorResponse>> getDebtToPay(@Valid @RequestBody SimulatorRequest simulatorRequest){
        Response<SimulatorResponse> response;

        response = service.getPayment(simulatorRequest);

        if(!Objects.isNull(response.getException()) && response.getException().getStatus().equals(HttpStatus.BAD_REQUEST)){
                return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(service.getPayment(simulatorRequest));
    }
}
