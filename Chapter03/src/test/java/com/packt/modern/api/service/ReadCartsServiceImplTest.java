package com.packt.modern.api.service;

import com.packt.modern.api.domain.Cart;
import com.packt.modern.api.domain.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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
        assertThat(sut.findById(customerId)).isNotEmpty();
    }

    private class CartRepositoryStub implements CartRepository {
        public Optional<Cart> findByCustomerId_will_returns = Optional.empty();

        @Override
        public Optional<Cart> findByCustomerId(final String customerId) {
            return findByCustomerId_will_returns;
        }

    }
}