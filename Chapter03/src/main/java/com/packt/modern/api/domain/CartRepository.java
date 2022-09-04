package com.packt.modern.api.domain;

import java.util.Optional;

public interface CartRepository {
    Optional<Cart> findByCustomerId(final String customerId);
}
