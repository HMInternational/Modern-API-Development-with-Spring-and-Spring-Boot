package com.packt.modern.api.controllers;

import com.packt.modern.api.CartApi;
import com.packt.modern.api.model.Cart;
import com.packt.modern.api.service.ReadCartsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CartsController implements CartApi {

    private ReadCartsService readCartsService;

    @Override
    public ResponseEntity<Cart> getCartByCustomerId(final String customerId) {
        readCartsService.findById(customerId);
        return CartApi.super.getCartByCustomerId(customerId);
    }
}
