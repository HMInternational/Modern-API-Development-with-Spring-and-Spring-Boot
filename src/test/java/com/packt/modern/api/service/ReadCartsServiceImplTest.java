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
        public <S extends CartEntity> S save(final S entity) {
            return null;
        }

        @Override
        public <S extends CartEntity> Iterable<S> saveAll(final Iterable<S> entities) {
            return null;
        }

        @Override
        public Optional<CartEntity> findById(final String customerId) {
            return cartEntity;
        }

        @Override
        public boolean existsById(final String s) {
            return false;
        }

        @Override
        public Iterable<CartEntity> findAll() {
            return null;
        }

        @Override
        public Iterable<CartEntity> findAllById(final Iterable<String> strings) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(final String s) {

        }

        @Override
        public void delete(final CartEntity entity) {

        }

        @Override
        public void deleteAllById(final Iterable<? extends String> strings) {

        }

        @Override
        public void deleteAll(final Iterable<? extends CartEntity> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public Optional<CartEntity> findByCustomerId(final String customerId) {
            return cartEntity;
        }
    }
}