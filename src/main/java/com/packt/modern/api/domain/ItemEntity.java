package com.packt.modern.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ItemEntity {
    String id;
    Integer quantity;
    BigDecimal unitPrice;
}
