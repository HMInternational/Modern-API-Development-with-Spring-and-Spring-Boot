package com.packt.modern.api.controllers;

import com.packt.modern.api.model.Cart;
import com.packt.modern.api.model.Item;
import com.packt.modern.api.service.CartDto;
import com.packt.modern.api.service.ItemDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class CartRepresentationModelAssembler {
    public CartRepresentationModelAssembler() {
    }

    ResponseEntity<Cart> mapToResponse(final CartDto cartDto) {
        final Cart cart = new Cart();
        cart.setItems(mapToItems(cartDto.items()));
        cart.setCustomerId(cartDto.customerId());
        cart.add(linkTo(methodOn(CartsController.class).getCartByCustomerId(cart.getCustomerId()))
                .withSelfRel());
        cart.add(linkTo(methodOn(CartsController.class)
                .getCartItemsByCustomerId(cart.getCustomerId())).withRel("cart-items"));
        return ResponseEntity.ok(cart);
    }

    private List<Item> mapToItems(final List<ItemDto> items) {
        return items
                .stream()
                .map(this::mapToItem)
                .toList();
    }

    private Item mapToItem(final ItemDto itemDto) {
        final Item item = new Item();
        item.setId(itemDto.id());
        item.setQuantity(itemDto.quantity());
        item.setUnitPrice(itemDto.unitPrice().doubleValue());
        return item;
    }
}