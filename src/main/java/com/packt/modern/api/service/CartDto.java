package com.packt.modern.api.service;

import java.util.List;

public record CartDto(String customerId, List<ItemDto> items) {
}
