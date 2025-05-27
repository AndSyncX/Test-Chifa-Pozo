package com.chifa.chifapozo.domain.model;

import lombok.Builder;

import java.time.LocalDate;

@Builder(toBuilder = true)
public record Promotion(
        Long id,
        String title,
        String description,
        String descountPercentage,
        LocalDate start_date,
        LocalDate end_date,
        boolean active,
        String image
) {

}
