package com.packt.modern.api.service;

import com.packt.modern.api.domain.CartEntity;
import com.packt.modern.api.domain.CartRepository;
import com.packt.modern.api.domain.ItemEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

class ReadCartsServiceImplTest {

    private CartRepositoryStub cartRepository;
    private ReadCartsService readCartsService;


    @BeforeEach
    void setUp() {
        cartRepository = new CartRepositoryStub();
        readCartsService = new ReadCartsServiceImpl(cartRepository);
    }

    @Test
    void findById() {
        // given
        String customerId = "uuid";
        final BigDecimal zero = BigDecimal.ZERO;
        final ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId("1");
        itemEntity.setQuantity(1);
        itemEntity.setUnitPrice(zero);
        cartRepository.cartEntity = Optional.of(new CartEntity(customerId, List.of(itemEntity, new ItemEntity())));

        // when
        final Optional<CartDto> customer = readCartsService.findById(customerId);

        // then
        Assertions.assertThat(customer).isPresent();
        Assertions.assertThat(customer.get().items()).hasSize(2);
        Assertions.assertThat(customer.get().items().get(0)).isEqualTo(new ItemDto("1", 1, zero));

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

    private static class CartRepositoryStub implements CartRepository {

        public Optional<CartEntity> cartEntity = Optional.empty();

        @Override
        public Optional<CartEntity> findById(final String customerId) {
            return cartEntity;
        }
    }
}