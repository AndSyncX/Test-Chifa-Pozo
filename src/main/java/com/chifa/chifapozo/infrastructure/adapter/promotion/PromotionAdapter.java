package com.chifa.chifapozo.infrastructure.adapter.promotion;

import com.chifa.chifapozo.domain.model.Promotion;
import com.chifa.chifapozo.domain.repository.PromotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PromotionAdapter implements PromotionRepository {
    private final PromotionDataRepository repository;
    private final PromotionMapper mapper;

    @Override
    public List<Promotion> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return repository.findById(id)
                .filter(PromotionData::isActive)
                .map(mapper::toDomain);
    }

    @Override
    public Promotion save(Promotion promotion){
        PromotionData data = repository.save(mapper.toEntity(promotion));
        return mapper.toDomain(data);
    }

    @Override
    public Promotion update(Promotion promotion){
        Optional<PromotionData> promotionData = repository.findById(promotion.id());
        if(promotionData.isPresent()){
            PromotionData data = mapper.toEntity(promotion);
            return mapper.toDomain(repository.save(data));
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<PromotionData> promotion = repository.findById(id);
        if (promotion.isPresent()){
            PromotionData promotionData = promotion.get();
            promotionData.setActive(false);
            repository.save(promotionData);
        }
    }



}
