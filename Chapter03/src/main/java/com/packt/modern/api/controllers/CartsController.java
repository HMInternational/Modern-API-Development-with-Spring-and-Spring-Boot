package com.packt.modern.api.controllers;

import com.packt.modern.api.CartApi;
import com.packt.modern.api.model.Cart;
import com.packt.modern.api.service.CartDto;
import com.packt.modern.api.service.ReadCartsService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CartsController implements CartApi {
    private final ReadCartsService readCartsService;
    private final CartRepresentationModelAssembler cartRepresentationModelAssembler = new CartRepresentationModelAssembler();

    CartsController(final ReadCartsService readCartsService) {
        this.readCartsService = readCartsService;
    }

    @Override
    public ResponseEntity<Cart> getCartByCustomerId(final String customerId) {
        final CartDto cartDto = getCartDto(customerId);
        return cartRepresentationModelAssembler.mapToResponse(cartDto);
    }

    private CartDto getCartDto(final String customerId) {
        return readCartsService
                .findById(customerId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("customer not found: (%s)".formatted(customerId)));
    }

}
