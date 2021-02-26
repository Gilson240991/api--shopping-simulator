package com.api.shoppingsimulator.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimulatorRequest implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    @JsonProperty("dni")
    private String dni;
    @JsonProperty("card")
    private String card;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("quota")
    private Integer quota;
    @JsonProperty("tea")
    private String tea;
    @JsonProperty("payDay")
    private Integer payDay;
    @JsonProperty("dateBuy")
    private String dateBuy;
}
