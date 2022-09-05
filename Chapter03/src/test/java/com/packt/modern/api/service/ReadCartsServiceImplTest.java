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
        cart.setId(UUID.randomUUID().toString());
        cart.setCustomerId(customerId);
        final UUID uuid = UUID.randomUUID();
        cart.setItems(List.of(
                createItem(uuid, "test-product-0", 1, 1000),
                createItem(uuid, "test-product-1", 2, 2000)));
        return Optional.of(cart);
    }

    private CartItem createItem(final UUID id, final String productId, final int quantity, final int unitPrice) {
        final CartItem cartItem = new CartItem();
        cartItem.setId(id.toString());
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

        @Override
        public <S extends Cart> S save(final S entity) {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public <S extends Cart> Iterable<S> saveAll(final Iterable<S> entities) {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public Optional<Cart> findById(final String s) {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public boolean existsById(final String s) {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public Iterable<Cart> findAll() {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public Iterable<Cart> findAllById(final Iterable<String> strings) {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public long count() {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public void deleteById(final String s) {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public void delete(final Cart entity) {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public void deleteAllById(final Iterable<? extends String> strings) {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public void deleteAll(final Iterable<? extends Cart> entities) {
            throw new UnsupportedOperationException("unimplemented");
        }

        @Override
        public void deleteAll() {
            throw new UnsupportedOperationException("unimplemented");
        }
    }
}