package com.api.shoppingsimulator.api.response;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Double quotaAmount;
    private String currency;
    private LocalDate firstQuota;
    private String state;
}
