package com.chifa.chifapozo.infrastructure.adapter.dish;

import com.chifa.chifapozo.domain.model.Dish;
import com.chifa.chifapozo.domain.repository.DishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DishAdapter implements DishRepository {

    private final DishDataRepository repository;
    private final DishMapper mapper;

    @Override
    public List<Dish> findAll() {
        return repository.findAll()
                .stream()
                .filter(dishData -> !dishData.isAvailable())
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return repository.findById(id)
                .filter(DishData::isAvailable)
                .map(mapper::toDomain);
    }

    @Override
    public Dish save(Dish dish) {
        DishData data = repository.save(mapper.toEntity(dish));
        return mapper.toDomain(data);
    }

    @Override
    public Dish update(Dish dish) {
        Optional<DishData> dishData = repository.findById(dish.id());
        if (dishData.isPresent()) {
            DishData data = mapper.toEntity(dish);
            return mapper.toDomain(repository.save(data));
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<DishData> dish = repository.findById(id);
        if (dish.isPresent()) {
            DishData dishData = dish.get();
            dishData.setAvailable(false);
            repository.save(dishData);
        }
    }
}
