package com.chifa.chifapozo.infrastructure.entity;

import com.chifa.chifapozo.domain.model.Dish;
import com.chifa.chifapozo.domain.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/chifapozo/dishes/")
public class DishController {

    private final DishService service;

    @GetMapping
    public List<Dish> getAllDishes() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Dish> getDishById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(service.save(dish));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody Dish dish) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(service.save(dish));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDishById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
