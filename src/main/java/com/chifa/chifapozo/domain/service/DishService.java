package com.chifa.chifapozo.domain.service;

import com.chifa.chifapozo.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    List<Dish> findAll();
    Optional<Dish> findById(Long id);
    Dish save(Dish dish);
    Dish update(Dish dish);
    void deleteById(Long id);
}
