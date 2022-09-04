package com.packt.modern.api.service;

import com.packt.modern.api.domain.Cart;
import com.packt.modern.api.domain.CartItem;
import com.packt.modern.api.domain.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class ReadCartsServiceImplTest {
    private final String customerId = "xxx";
    private CartRepositoryStub cartRepository;

    private ReadCartsServiceImpl sut;

    @BeforeEach
    void setUp() {
        cartRepository = new CartRepositoryStub();
        sut = new ReadCartsServiceImpl(cartRepository);
    }

    @Test
    void findById() {
        cartRepository.findByCustomerId_will_returns = Optional.empty();
        assertThat(sut.findById(customerId)).isEmpty();

        cartRepository.findByCustomerId_will_returns = stubCart();
        final CartDto cartDto = sut.findById(customerId).orElseThrow();
        assertThat(cartDto.customerId()).isEqualTo(customerId);
        assertThat(cartDto.items()).hasSize(2);
    }

    private Optional<Cart> stubCart() {
        final Cart cart = new Cart();
        cart.setId(UUID.randomUUID());
        cart.setCustomerId(customerId);
        cart.setItems(List.of(
                createItem(UUID.randomUUID(), "test-product-0", 1, 1000),
                createItem(UUID.randomUUID(), "test-product-1", 2, 2000)));
        return Optional.of(cart);
    }

    private CartItem createItem(final UUID id, final String productId, final int quantity, final int unitPrice) {
        final CartItem cartItem = new CartItem();
        cartItem.setId(id);
        cartItem.setProductId(productId);
        cartItem.setQuantity(quantity);
        cartItem.setUnitPrice(BigDecimal.valueOf(unitPrice));
        return cartItem;
    }

    private class CartRepositoryStub implements CartRepository {
        public Optional<Cart> findByCustomerId_will_returns = Optional.empty();

        @Override
        public Optional<Cart> findByCustomerId(final String customerId) {
            return findByCustomerId_will_returns;
        }

    }
}