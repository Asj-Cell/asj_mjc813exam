package com.mjc813.food_web.ingredient.service;

import com.mjc813.food_web.ingredient.dto.IngredientDto;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public void insert(IngredientDto dto){
        IngredientCategoryEntity categoryEntity = new IngredientCategoryEntity();
        categoryEntity.setId(dto.getIngredientCategoryId());

        IngredientEntity entity = new IngredientEntity();
        entity.setIngredientCategory(categoryEntity);
        entity.copyIngredient(dto);
        this.ingredientRepository.save(entity);
    }
    public List<IngredientEntity> findAll(){
        return this.ingredientRepository.findAll();
    }

    public IngredientEntity findById(Long id){
        Optional<IngredientEntity> findById = this.ingredientRepository.findById(id);
        return findById.orElse(null);
    }

    public void update(IngredientDto dto){
        IngredientEntity entity = new IngredientEntity();
        entity.copyIngredient(dto);
        this.ingredientRepository.save(entity);
    }

    public void delete(Long id){
        this.ingredientRepository.deleteById(id);
    }
}
