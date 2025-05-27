package com.chifa.chifapozo.infrastructure.adapter.dish;

import com.chifa.chifapozo.domain.model.Dish;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DishMapper {
    Dish toDomain(DishData entity);
    DishData toEntity(Dish domain);
}
