package com.mjc813.food_web.ingredient_category.dto;

public interface IIngredientCategory {
    public Long getId();
    public String getName();
    public void setId(Long id);
    public void setName(String name);

    default void copyIngredientCategory(IngredientCategoryDto from){
        setId(from.getId());
        setName(from.getName());
    }
}
