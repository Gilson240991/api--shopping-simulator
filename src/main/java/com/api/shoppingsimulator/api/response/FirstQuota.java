package com.api.shoppingsimulator.api.response;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FirstQuota {
    private Payment principalPayment;
}
