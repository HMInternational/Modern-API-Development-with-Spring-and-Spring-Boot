package com.packt.modern.api.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@DataJpaTest
class CartRepositoryTest {


    @Autowired
    CartRepository cartRepository;

    @Test
    @Sql("insert-cart.sql")
    void findById() {
        final String customerId = "uuid";

        final Optional<CartEntity> optionalCartEntity = cartRepository.findByCustomerId(customerId);

        Assertions.assertThat(optionalCartEntity).isPresent();
    }

    @Test
    void findById_empty() {
        final String customerId = "";

        final Optional<CartEntity> optionalCartEntity = cartRepository.findByCustomerId(customerId);

        Assertions.assertThat(optionalCartEntity).isEmpty();
    }
}