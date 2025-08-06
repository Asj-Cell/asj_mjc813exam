package com.mjc813.food_web.food.dto;

public interface IFood {

    public Long getId();
    public String getName();
    public Integer getSpicyLevel();
    public Integer getSweetLevel();
    public Integer getSourLevel();
    public Integer getSaltyLevel();
    public Long getIngredientId();
    public Long getFoodCategoryId();
    public void setId(Long id);
    public void setName(String name);
    public void setSpicyLevel(Integer spicyLevel);
    public void setSweetLevel(Integer sweetLevel);
    public void setSourLevel(Integer sourLevel);
    public void setSaltyLevel(Integer saltyLevel);
    public void setIngredientId(Long ingredientId);
    public void setFoodCategoryId(Long foodCategoryId);

    default void copyFoods(FoodDto from){
        setId(from.getId());
        setName(from.getName());
        setSpicyLevel(from.getSpicyLevel());
        setSweetLevel(from.getSweetLevel());
        setSourLevel(from.getSourLevel());
        setSaltyLevel(from.getSaltyLevel());
        setIngredientId(from.getIngredientId());
        setFoodCategoryId(from.getFoodCategoryId());
    }
}
