package com.packt.modern.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Table(name = "cart")
@Entity
public class Cart {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "customer_id")
    private String customerId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_item",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<CartItem> items;
}
