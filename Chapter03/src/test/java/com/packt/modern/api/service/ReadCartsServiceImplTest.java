package com.packt.modern.api.service;

import com.packt.modern.api.domain.Cart;
import com.packt.modern.api.domain.CartRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ReadCartsServiceImplTest {

    @Test
    void findById() {
        final var sut = new ReadCartsServiceImpl(new CartRepositoryStub());
        assertThat(sut.findById("xxx")).isNotEmpty();
    }

    private class CartRepositoryStub implements CartRepository {
        public Optional<Cart> findByCustomerId_will_returns = Optional.empty();

        @Override
        public Optional<Cart> findByCustomerId(final String customerId) {
            return findByCustomerId_will_returns;
        }

    }
}