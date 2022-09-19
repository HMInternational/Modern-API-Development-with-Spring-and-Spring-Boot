package com.packt.modern.api.controllers;

import com.packt.modern.api.CartApi;
import com.packt.modern.api.model.Cart;
import com.packt.modern.api.model.Item;
import com.packt.modern.api.service.CartDto;
import com.packt.modern.api.service.ItemDto;
import com.packt.modern.api.service.ReadCartsService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class CartsController implements CartApi {
    private final ReadCartsService readCartsService;

    CartsController(final ReadCartsService readCartsService) {
        this.readCartsService = readCartsService;
    }

    @Override
    public ResponseEntity<Cart> getCartByCustomerId(final String customerId) {
        final CartDto cartDto = getCartDto(customerId);
        return mapToResponse(cartDto);
    }

    private CartDto getCartDto(final String customerId) {
        return readCartsService
                .findById(customerId)
                .orElseThrow(() ->
                        new OpenApiResourceNotFoundException("customer not found: (%s)".formatted(customerId)));
    }

    private ResponseEntity<Cart> mapToResponse(final CartDto cartDto) {
        final Cart cart = new Cart();
        cart.setItems(mapToItems(cartDto.items()));
        cart.setCustomerId(cartDto.customerId());
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
