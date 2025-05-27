package com.chifa.chifapozo.infrastructure.adapter.promotion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "chifapozo", name = "promotions")

public class PromotionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String descountPercentage;

    private LocalDate start_date;

    private LocalDate end_date;

    private boolean active;

    private String image;


}
