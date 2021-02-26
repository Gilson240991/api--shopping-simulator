package com.api.shoppingsimulator.service;

import com.api.shoppingsimulator.api.request.SimulatorRequest;
import com.api.shoppingsimulator.api.response.SimulatorResponse;
import com.api.shoppingsimulator.util.Response;

public interface SimulatorService {

     Response<SimulatorResponse> getPayment(SimulatorRequest simulatorRequest);

}
