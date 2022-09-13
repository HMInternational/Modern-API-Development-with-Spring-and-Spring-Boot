package com.packt.modern.api.domain;

import java.util.ArrayList;
import java.util.List;

public class CartEntity {

    String customerId;
    List<ItemEntity> items = new ArrayList<>();

    public String getCustomerId() {
        return customerId;
    }

    public List<ItemEntity> getItems() {
        return items;
    }
}
