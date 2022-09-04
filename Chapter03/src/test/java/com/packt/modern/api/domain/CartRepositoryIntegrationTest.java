package com.packt.modern.api.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CartRepositoryIntegrationTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    void findByCustomerId_not_exists() {
        assertThat(cartRepository.findByCustomerId("xxx")).isEmpty();
    }

    @Test
    void findByCustomerId_exists() {
        final String customerId = "testing-customer-id";

        final Cart cart = cartRepository.findByCustomerId(customerId).orElseThrow();

        assertThat(cart.getCustomerId()).isEqualTo(customerId);
        assertThat(cart.getItems()).hasSize(2);
    }
}