package com.packt.modern.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Cart {
    private UUID id;

    private String customerId;

    private List<CartItem> items;
}
