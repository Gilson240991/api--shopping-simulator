package com.api.shoppingsimulator.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimulatorRequest implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    @NotNull
    @Size(max = 8,min = 8)
    private String dni;
    @NotNull
    @Pattern(regexp = "(Clásica|Oro|Black)$",message = "Solo puede ingresar tipo de tarjeta: Clásica,Oro o Black")
    @JsonProperty("card")
    private String card;
    @NotNull
    @Pattern(regexp = "(Soles|Dolares)$",message = "Solo puede ingresar tipo de moneda: Soles o Dolares")
    @JsonProperty("currency")
    private String currency;
    @NotNull
    @JsonProperty("amount")
    private Double amount;
    @NotNull
    @JsonProperty("quota")
    private Integer quota;
    @NotNull
    @Pattern(regexp = "(99.90%|95.90%|90.90%)$",message = "Solo puede ingresar los tipos de tea: 99.90%, 95.90% o 90.90%")
    @JsonProperty("tea")
    private String tea;
    @NotNull
    @Pattern(regexp = "(5|20)$",message = "Solo puede ingresar dias de pagos: 5 o 20")
    @JsonProperty("payDay")
    private String payDay;
    @NotNull
    @JsonProperty("dateBuy")
    private String dateBuy;
}
