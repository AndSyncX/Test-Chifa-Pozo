package com.chifa.chifapozo.domain.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder(toBuilder = true)
public record Dish(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String imageUrl,
        boolean available
) {
}
