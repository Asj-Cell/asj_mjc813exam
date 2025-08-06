package com.mjc813.food_web.ingredient_category.service;

import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientCategoryService {
    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    public void insert(IngredientCategoryDto dto){
        IngredientCategoryEntity entity = new IngredientCategoryEntity();
        entity.copyIngredientCategory(dto);
        this.ingredientCategoryRepository.save(entity);
    }

    public List<IngredientCategoryEntity> findAll(){
        return this.ingredientCategoryRepository.findAll();
    }

    public IngredientCategoryEntity findById(Long id){
        Optional<IngredientCategoryEntity> findById = this.ingredientCategoryRepository.findById(id);
        return findById.orElse(null);
    }

    public void update(IngredientCategoryDto dto){
        IngredientCategoryEntity entity = new IngredientCategoryEntity();
        entity.copyIngredientCategory(dto);
        this.ingredientCategoryRepository.save(entity);
    }

    public void delete(Long id){
        this.ingredientCategoryRepository.deleteById(id);
    }
}
