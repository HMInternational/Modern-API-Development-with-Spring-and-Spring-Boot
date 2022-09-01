package com.packt.modern.api.service;

import java.util.List;
import java.util.Optional;

public class ReadCartsServiceStub implements ReadCartsService {

    @Override
    public Optional<CartDto> findById(final String customerId) {
        if (!"uuid".equals(customerId)) return Optional.empty();
        return Optional.of(createDto(customerId));
    }

    private CartDto createDto(final String customerId) {
        final List<ItemDto> items = List.of(new ItemDto(), new ItemDto());
        return new CartDto(customerId, items);
    }
}
