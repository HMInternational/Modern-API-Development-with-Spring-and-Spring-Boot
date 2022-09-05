package com.packt.modern.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "item")
public class CartItem {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private Integer quantity;
}
