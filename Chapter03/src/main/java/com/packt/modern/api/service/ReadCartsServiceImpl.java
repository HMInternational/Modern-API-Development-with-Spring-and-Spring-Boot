package com.packt.modern.api.service;

import com.packt.modern.api.domain.Cart;
import com.packt.modern.api.domain.CartItem;
import com.packt.modern.api.domain.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class ReadCartsServiceImpl implements ReadCartsService {
    private final CartRepository cartRepository;

    ReadCartsServiceImpl(final CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Optional<CartDto> findById(final String customerId) {
        return cartRepository
                .findByCustomerId(customerId)
                .map(this::mapToDto);
    }

    private CartDto mapToDto(final Cart cart) {
        return new CartDto(cart.getCustomerId(), mapToDtos(cart.getItems()));
    }

    private List<ItemDto> mapToDtos(final List<CartItem> items) {
        return items
                .stream()
                .map(this::mapItemToDto)
                .toList();
    }

    private ItemDto mapItemToDto(final CartItem cartItem) {
        return new ItemDto(cartItem.getId().toString(), cartItem.getQuantity(), cartItem.getUnitPrice());
    }
}
