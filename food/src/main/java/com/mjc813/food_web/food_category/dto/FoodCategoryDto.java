package com.mjc813.food_web.food_category.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategoryDto implements IFoodCategory{
    private Long id;
    private String name ;

}
