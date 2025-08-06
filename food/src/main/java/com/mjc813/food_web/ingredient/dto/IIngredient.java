package com.mjc813.food_web.ingredient.dto;

import com.mjc813.food_web.food.dto.FoodDto;

public interface IIngredient {
    public Long getId();
    public String getName();
    public Long getIngredientCategoryId();
    public void setId(Long id);
    public void setName(String name);
    public void setIngredientCategoryId(Long categoryId);

    default void copyIngredient(IngredientDto from){
        setId(from.getId());
        setName(from.getName());
        setIngredientCategoryId(from.getIngredientCategoryId());
    }
}
