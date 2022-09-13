package com.packt.modern.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class ItemEntity {
    @Id
    @Column(name = "id")
    String id;
    @Column(name = "quantity")
    Integer quantity;
    @Column(name = "unit_price")
    BigDecimal unitPrice;
}
