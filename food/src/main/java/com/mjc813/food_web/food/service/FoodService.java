package com.mjc813.food_web.food.service;

import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.food_category.service.FoodCategoryRepository;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import com.mjc813.food_web.ingredient.service.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    public void insert(FoodDto dto){

//        IngredientEntity ingredientEntity = ingredientRepository.findById(dto.getIngredientId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid ingredient ID: " + dto.getIngredientId()));
//
//        FoodCategoryEntity foodCategory = foodCategoryRepository.findById(dto.getFoodCategoryId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid food category ID"));

        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setId(dto.getIngredientId());

        FoodCategoryEntity foodCategory = new FoodCategoryEntity();
        foodCategory.setId(dto.getFoodCategoryId());

        FoodEntity entity = new FoodEntity();
        entity.setFoodCategory(foodCategory);
        entity.setIngredient(ingredientEntity);
        entity.copyFoods(dto);
        this.foodRepository.save(entity);
    }

    public List<FoodEntity> findAll(){
        return this.foodRepository.findAll();
    }

    public FoodEntity findById(Long id){
        Optional<FoodEntity> findById = this.foodRepository.findById(id);
        return findById.orElse(null);
    }

    public void update(FoodDto dto){
        IngredientEntity ingredientEntity = ingredientRepository.findById(dto.getIngredientId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ingredient ID: " + dto.getIngredientId()));

        FoodCategoryEntity foodCategory = foodCategoryRepository.findById(dto.getFoodCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid food category ID"));

        FoodEntity entity = new FoodEntity();
        entity.setFoodCategory(foodCategory);
        entity.setIngredient(ingredientEntity);
        entity.copyFoods(dto);
        this.foodRepository.save(entity);
    }

    public void delete(Long id){
        this.foodRepository.deleteById(id);
    }
}
