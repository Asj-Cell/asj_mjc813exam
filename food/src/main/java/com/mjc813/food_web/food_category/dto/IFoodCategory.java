package com.mjc813.food_web.food_category.dto;

import com.mjc813.food_web.food.dto.FoodDto;

public interface IFoodCategory {

    public Long getId();
    public String getName();
    public void setId(Long id);
    public void setName(String name);

    default void copyFoodCategory(FoodCategoryDto from){
        setId(from.getId());
        setName(from.getName());
    }
}
