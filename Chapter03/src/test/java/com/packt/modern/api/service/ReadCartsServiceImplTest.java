package com.packt.modern.api.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReadCartsServiceImplTest {

    @Test
    void findById() {
        final var sut = new ReadCartsServiceImpl(null);
        assertThat(sut.findById("xxx")).isNotEmpty();
    }
}