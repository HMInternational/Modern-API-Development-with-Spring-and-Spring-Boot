package com.packt.modern.api.service;

import java.util.Optional;

public interface ReadCartsService {
    Optional<CartDto> findById(String customerId);
}
