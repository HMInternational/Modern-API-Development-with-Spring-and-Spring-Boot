package com.packt.modern.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CartItem {
    private UUID id;

    private String productId;

    private BigDecimal unitPrice;

    private Integer quantity;
}
