package com.chifa.chifapozo.domain.service;

import com.chifa.chifapozo.domain.model.Dish;
import com.chifa.chifapozo.domain.repository.DishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DishServiceImpl implements DishService{

    private final DishRepository repository;

    @Override
    public List<Dish> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public Dish update(Dish dish) {
        return repository.update(dish);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
