package com.mjc813.food_web.ingredient.service;

import com.mjc813.food_web.ingredient.dto.IngredientDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IngredientMapper {
    void insert(IngredientDto dto);
    void update(IngredientDto dto);
    void delete(Long id);
    IngredientDto findById(Long id);
    List<IngredientDto> findAll();
}
