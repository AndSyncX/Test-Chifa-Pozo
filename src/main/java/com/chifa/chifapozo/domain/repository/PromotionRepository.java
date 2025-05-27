package com.chifa.chifapozo.domain.repository;

import com.chifa.chifapozo.domain.model.Dish;
import com.chifa.chifapozo.domain.model.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionRepository {
    List<Promotion>findAll();
    Optional<Promotion> findById(Long id);
    Promotion save(Promotion promotion);
    Promotion update(Promotion promotion);
    void deleteById(Long id);
}
