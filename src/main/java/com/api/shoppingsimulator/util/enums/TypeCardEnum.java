package com.api.shoppingsimulator.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeCardEnum {
    CLASSIC("Clasica"),
    GOLD("Oro"),
    BLACK("Black");

    private String name;

}
