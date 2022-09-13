package com.packt.modern.api.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class ReadCartsServiceImplTest {

    private final ReadCartsService readCartsService = new ReadCartsServiceImpl();

    @Test
    void findById() {
        // given
        String customerId = "uuid";

        // when
        final Optional<CartDto> customer = readCartsService.findById(customerId);

        // then
        Assertions.assertThat(customer).isPresent();

    }

    @Test
    void findById_argument_null() {
        // given
        String customerId = null;

        // when
        Assertions.assertThatThrownBy(() -> readCartsService.findById(customerId))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void findById_empty() {
        // given
        String customerId = "uuid1";

        // when
        Optional<CartDto> optionalCartDto = readCartsService.findById(customerId);

        // then
        Assertions.assertThat(optionalCartDto).isEmpty();
    }
}