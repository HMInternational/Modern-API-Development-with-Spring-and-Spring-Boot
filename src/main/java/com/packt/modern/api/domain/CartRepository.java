package com.packt.modern.api.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<CartEntity, String> {

    Optional<CartEntity> findByCustomerId(String customerId);
}
