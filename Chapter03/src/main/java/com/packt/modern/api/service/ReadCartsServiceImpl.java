package com.packt.modern.api.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ReadCartsServiceImpl implements ReadCartsService {

    @Override
    public Optional<CartDto> findById(final String customerId) {
        // TODO 진짜 구현으로 변경하기.
        if (!"uuid".equals(customerId)) return Optional.empty();
        return Optional.of(stubCartDto(customerId));
    }

    private CartDto stubCartDto(final String customerId) {
        return new CartDto(
                customerId,
                List.of(new ItemDto("id-0", 1, BigDecimal.valueOf(1000)),
                        new ItemDto("id-1", 2, BigDecimal.valueOf(500))));
    }

}
