package com.chifa.chifapozo.infrastructure.adapter.promotion;

import com.chifa.chifapozo.domain.model.Promotion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    Promotion toDomain(PromotionData entity);
    PromotionData toEntity(Promotion domain);
}
