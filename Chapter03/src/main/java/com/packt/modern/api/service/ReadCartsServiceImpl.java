package com.packt.modern.api.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class ReadCartsServiceImpl implements ReadCartsService {

    @Override
    public Optional<CartDto> findById(final String customerId) {
        throw new UnsupportedOperationException("unimplemented");
    }
}
