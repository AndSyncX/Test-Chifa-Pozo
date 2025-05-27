package com.chifa.chifapozo.infrastructure.entity;

import com.chifa.chifapozo.domain.model.Promotion;
import com.chifa.chifapozo.domain.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/chifapozo/promotions/")
public class PromotionController {
    private final PromotionService service;
    @GetMapping
    public List<Promotion> getAllPromotion() {return service.findAll();}

    @GetMapping("/{id}")
    public Optional<Promotion> getPromotionById(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(promotion));}

    @PutMapping("/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable Long id, @RequestBody Promotion promotion) {return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(promotion));}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromotionById(@PathVariable Long id) {service.deleteById(id);return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
}
