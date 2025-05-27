package com.chifa.chifapozo.domain.service;

import com.chifa.chifapozo.domain.model.Promotion;
import com.chifa.chifapozo.domain.repository.PromotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository repository;

    @Override
    public List<Promotion> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Promotion save(Promotion promotion) {
        return repository.save(promotion);
    }

    @Override
    public Promotion update(Promotion promotion) {
        return repository.update(promotion);
    }

    @Override
    public void deleteById(Long id) {repository.deleteById(id);

    }
}
