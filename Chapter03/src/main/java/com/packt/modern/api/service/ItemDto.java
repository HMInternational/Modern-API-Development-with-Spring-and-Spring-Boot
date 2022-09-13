package com.packt.modern.api.service;

import java.math.BigDecimal;

public record ItemDto(String id, Integer quantity, BigDecimal unitPrice) {
}
