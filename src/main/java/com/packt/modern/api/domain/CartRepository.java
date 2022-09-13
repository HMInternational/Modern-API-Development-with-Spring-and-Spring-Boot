package com.packt.modern.api.domain;

import java.util.Optional;

public interface CartRepository {
    Optional<CartEntity> findById(String customerId);
}
