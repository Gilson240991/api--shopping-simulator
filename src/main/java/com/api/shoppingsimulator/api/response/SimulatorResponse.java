package com.api.shoppingsimulator.api.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimulatorResponse implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    private Payment firstQuota;
    private List<Payment> listPayment;
}
