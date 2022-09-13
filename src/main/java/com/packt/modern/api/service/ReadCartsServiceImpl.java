package com.packt.modern.api.service;

import com.packt.modern.api.domain.CartEntity;
import com.packt.modern.api.domain.CartRepository;
import com.packt.modern.api.domain.ItemEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReadCartsServiceImpl implements ReadCartsService {

    private final CartRepository cartRepository;

    public ReadCartsServiceImpl(final CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CartDto> findById(final String customerId) {
        if (null == customerId) throw new IllegalArgumentException("Customer Identifier  cannot be null");

        return cartRepository.findByCustomerId(customerId)
                .map(this::mapToDto);
    }

    private CartDto mapToDto(final CartEntity cartEntity) {
        return new CartDto(cartEntity.getCustomerId(), mapToItemsDto(cartEntity.getItems()));
    }

    private List<ItemDto> mapToItemsDto(final List<ItemEntity> items) {
        return items.stream().map(itemEntity -> new ItemDto(itemEntity.getId(), itemEntity.getQuantity(), itemEntity.getUnitPrice())).toList();
    }

}
