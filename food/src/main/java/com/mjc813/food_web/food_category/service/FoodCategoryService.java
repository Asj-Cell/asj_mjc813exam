package com.mjc813.food_web.food_category.service;

import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCategoryService {

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    public void insert(FoodCategoryDto dto){
        FoodCategoryEntity entity = new FoodCategoryEntity();
        entity.copyFoodCategory(dto);
        this.foodCategoryRepository.save(entity);
    }

    public List<FoodCategoryEntity> findAll(){
        return this.foodCategoryRepository.findAll();
    }

    public FoodCategoryEntity findById(Long id){
        Optional<FoodCategoryEntity> findById = this.foodCategoryRepository.findById(id);
        return findById.orElse(null);
    }

    public void update(FoodCategoryDto dto){
        FoodCategoryEntity entity = new FoodCategoryEntity();
        entity.copyFoodCategory(dto);
        this.foodCategoryRepository.save(entity);
    }

    public void delete(Long id){
        this.foodCategoryRepository.deleteById(id);
    }

}
