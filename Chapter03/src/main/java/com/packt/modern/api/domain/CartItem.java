package com.packt.modern.api.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

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

    @Comment("상품ID")
    @Column(name = "product_id")
    private String productId;

    @Comment("단가")
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Comment("수량")
    @Column(name = "quantity")
    private Integer quantity;
}
