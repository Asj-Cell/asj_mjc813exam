package com.mjc813.food_web.ingredient.dto;

import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestIngredientType {
    @Test
    public void testIngredientDtoEntity() {
        IngredientCategoryEntity ingredientCategoryEntity = new IngredientCategoryEntity(10L, "야채");
        IngredientCategoryDto ingredientCategoryDto = new IngredientCategoryDto();
        ingredientCategoryDto.copyMembersIdName(ingredientCategoryEntity);

        assertThat(ingredientCategoryDto.getId()).isEqualTo(ingredientCategoryEntity.getId());
        assertThat(ingredientCategoryDto.getName()).isEqualTo(ingredientCategoryEntity.getName());

        IngredientEntity ingredientEntity = IngredientEntity.builder()
                .id(30L)
                .name("고추")
                .ingredientCategoryEntity(ingredientCategoryEntity)
                .build();
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.copyMembersIngredient(ingredientEntity);

        assertThat(ingredientDto.getId()).isEqualTo(ingredientEntity.getId());
        assertThat(ingredientDto.getName()).isEqualTo(ingredientEntity.getName());
        assertThat(ingredientDto.getIngredientCategoryId()).isEqualTo(ingredientEntity.getIngredientCategoryId());
        assertThat(ingredientDto.getIngredientCategory().getId()).isEqualTo(ingredientEntity.getIngredientCategory().getId());
        assertThat(ingredientDto.getIngredientCategory().getName()).isEqualTo(ingredientEntity.getIngredientCategory().getName());

        ingredientEntity.setIngredientCategoryId(20L);
        assertThat(ingredientDto.getIngredientCategoryId()).isNotEqualTo(ingredientEntity.getIngredientCategoryId());
        assertThat(ingredientEntity.getIngredientCategoryId()).isEqualTo(20L);
        assertThat(ingredientEntity.getIngredientCategoryEntity().getId()).isEqualTo(20L);
        assertThat(ingredientEntity.getIngredientCategory().getId()).isEqualTo(20L);

        ingredientEntity.getIngredientCategoryEntity().setId(40L);
        assertThat(ingredientEntity.getIngredientCategoryEntity().getId()).isEqualTo(40L);
        assertThat(ingredientEntity.getIngredientCategory().getId()).isEqualTo(40L);
        assertThat(ingredientEntity.getIngredientCategoryId()).isEqualTo(40L);
    }

    @Test
    public void testIngredientEntityDto() {
        IngredientCategoryDto ingredientCategoryDto = new IngredientCategoryDto(22L, "고기");
        IngredientCategoryEntity ingredientCategoryEntity = new IngredientCategoryEntity();
        ingredientCategoryEntity.copyMembersIdName(ingredientCategoryDto);

        assertThat(ingredientCategoryEntity.getId()).isEqualTo(ingredientCategoryDto.getId());
        assertThat(ingredientCategoryEntity.getName()).isEqualTo(ingredientCategoryDto.getName());

        IngredientDto ingredientDto = IngredientDto.builder()
                .id(30L)
                .name("ingredientEntity")
                .ingredientCategoryDto(ingredientCategoryDto)
                .build();
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.copyMembersIngredient(ingredientDto);

        assertThat(ingredientEntity.getId()).isEqualTo(ingredientDto.getId());
        assertThat(ingredientEntity.getName()).isEqualTo(ingredientDto.getName());
        assertThat(ingredientEntity.getIngredientCategoryId()).isEqualTo(ingredientDto.getIngredientCategoryId());
        assertThat(ingredientEntity.getIngredientCategory().getId()).isEqualTo(ingredientDto.getIngredientCategory().getId());
        assertThat(ingredientEntity.getIngredientCategory().getName()).isEqualTo(ingredientDto.getIngredientCategory().getName());

        ingredientDto.setIngredientCategoryId(67L);
        assertThat(ingredientDto.getIngredientCategoryId()).isNotEqualTo(ingredientEntity.getIngredientCategoryId());
        assertThat(ingredientDto.getIngredientCategoryId()).isEqualTo(67L);
        assertThat(ingredientDto.getIngredientCategoryDto().getId()).isEqualTo(67L);
        assertThat(ingredientDto.getIngredientCategory().getId()).isEqualTo(67L);

        ingredientDto.getIngredientCategory().setId(888L);
        assertThat(ingredientDto.getIngredientCategoryDto().getId()).isEqualTo(888L);
        assertThat(ingredientDto.getIngredientCategory().getId()).isEqualTo(888L);
        assertThat(ingredientDto.getIngredientCategoryId()).isEqualTo(888L);// 외래키객체의 setId(번호)를 하면 외래키번호는 설정이 안되는 현상
    }

    @Test
    public void testFoodDtoEntity() {
        FoodEntity foodEntity = FoodEntity.builder()
                .id(77L)
                .name("짜장면")
                .spicyLevel(0)
                .sweetLevel(5)
                .sourLevel(1)
                .saltyLevel(2)
//                .ingredientEntity(
//                        IngredientEntity.builder()
//                                .id(35L)
//                                .name("굵은면")
//                                .ingredientCategoryEntity(
//                                        new IngredientCategoryEntity(7L, "가공식품")
//                                )
//                                .build()
//                )
                .foodCategoryEntity(
                        new FoodCategoryEntity(5L, "주식")
                )
                .build();
        FoodDto foodDto = new FoodDto();
        foodDto.copyMembersFood(foodEntity);

        assertThat(foodDto.getId()).isEqualTo(foodEntity.getId());
        assertThat(foodDto.getName()).isEqualTo(foodEntity.getName());
        assertThat(foodDto.getSpicyLevel()).isEqualTo(foodEntity.getSpicyLevel());
        assertThat(foodDto.getSweetLevel()).isEqualTo(foodEntity.getSweetLevel());
        assertThat(foodDto.getSourLevel()).isEqualTo(foodEntity.getSourLevel());
        assertThat(foodDto.getSaltyLevel()).isEqualTo(foodEntity.getSaltyLevel());
//        assertThat(foodDto.getIngredient().getId()).isEqualTo(foodEntity.getIngredient().getId());
//        assertThat(foodDto.getIngredient().getName()).isEqualTo(foodEntity.getIngredient().getName());
//        assertThat(foodDto.getIngredient().getIngredientCategoryId()).isEqualTo(foodEntity.getIngredient().getIngredientCategoryId());
//        assertThat(foodDto.getIngredient().getIngredientCategory().getId()).isEqualTo(foodEntity.getIngredient().getIngredientCategory().getId());
//        assertThat(foodDto.getIngredient().getIngredientCategory().getName()).isEqualTo(foodEntity.getIngredient().getIngredientCategory().getName());
        assertThat(foodDto.getFoodCategoryId()).isEqualTo(foodEntity.getFoodCategoryId());
        assertThat(foodDto.getFoodCategory().getId()).isEqualTo(foodEntity.getFoodCategory().getId());
        assertThat(foodDto.getFoodCategory().getName()).isEqualTo(foodEntity.getFoodCategory().getName());

//        foodEntity.getIngredient().setId(99999L);
//        assertThat(foodDto.getIngredient().getId()).isNotEqualTo(foodEntity.getIngredient().getId());
//        assertThat(foodEntity.getIngredient().getId()).isEqualTo(99999L);
//        assertThat(foodEntity.getIngredientEntity().getId()).isEqualTo(99999L);
//        assertThat(foodEntity.getIngredientId()).isEqualTo(99999L);
//
//        foodEntity.setIngredientId(9872L);
//        assertThat(foodDto.getIngredient().getId()).isNotEqualTo(foodEntity.getIngredient().getId());
//        assertThat(foodEntity.getIngredientId()).isEqualTo(9872L);
//        assertThat(foodEntity.getIngredient().getId()).isEqualTo(9872L);
//        assertThat(foodEntity.getIngredientEntity().getId()).isEqualTo(9872L);
//
//        foodEntity.getIngredient().getIngredientCategory().setId(77777L);
//        assertThat(foodDto.getIngredient().getIngredientCategory().getId()).isNotEqualTo(foodEntity.getIngredient().getIngredientCategory().getId());
//        assertThat(foodEntity.getIngredient().getIngredientCategory().getId()).isEqualTo(77777L);
//        assertThat(foodEntity.getIngredientEntity().getIngredientCategoryEntity().getId()).isEqualTo(77777L);
//        assertThat(foodEntity.getIngredient().getIngredientCategoryId()).isEqualTo(77777L);

        foodEntity.getFoodCategory().setId(667L);
        assertThat(foodDto.getFoodCategory().getId()).isNotEqualTo(foodEntity.getFoodCategory().getId());
        assertThat(foodEntity.getFoodCategory().getId()).isEqualTo(667L);
        assertThat(foodEntity.getFoodCategoryEntity().getId()).isEqualTo(667L);
        assertThat(foodEntity.getFoodCategoryId()).isEqualTo(667L);
    }

    @Test
    public void testFoodEntityDto() {
        FoodDto foodDto = FoodDto.builder()
                .id(77L)
                .name("짜장면")
                .spicyLevel(0)
                .sweetLevel(5)
                .sourLevel(1)
                .saltyLevel(2)
//                .ingredientDto(
//                        IngredientDto.builder()
//                                .id(35L)
//                                .name("굵은면")
//                                .ingredientCategoryDto(
//                                        new IngredientCategoryDto(7L, "가공식품")
//                                )
//                                .build()
//                )
                .foodCategoryDto(
                        new FoodCategoryDto(5L, "주식")
                )
                .build();
        FoodEntity footEntity = new FoodEntity();
        footEntity.copyMembersFood(foodDto);

        assertThat(footEntity.getId()).isEqualTo(foodDto.getId());
        assertThat(footEntity.getName()).isEqualTo(foodDto.getName());
        assertThat(footEntity.getSpicyLevel()).isEqualTo(foodDto.getSpicyLevel());
        assertThat(footEntity.getSweetLevel()).isEqualTo(foodDto.getSweetLevel());
        assertThat(footEntity.getSourLevel()).isEqualTo(foodDto.getSourLevel());
        assertThat(footEntity.getSaltyLevel()).isEqualTo(foodDto.getSaltyLevel());
//        assertThat(footEntity.getIngredient().getId()).isEqualTo(foodDto.getIngredient().getId());
//        assertThat(footEntity.getIngredient().getName()).isEqualTo(foodDto.getIngredient().getName());
//        assertThat(footEntity.getIngredient().getIngredientCategoryId()).isEqualTo(foodDto.getIngredient().getIngredientCategoryId());
//        assertThat(footEntity.getIngredient().getIngredientCategory().getId()).isEqualTo(foodDto.getIngredient().getIngredientCategory().getId());
//        assertThat(footEntity.getIngredient().getIngredientCategory().getName()).isEqualTo(foodDto.getIngredient().getIngredientCategory().getName());
        assertThat(footEntity.getFoodCategoryId()).isEqualTo(foodDto.getFoodCategoryId());
        assertThat(footEntity.getFoodCategory().getId()).isEqualTo(foodDto.getFoodCategory().getId());
        assertThat(footEntity.getFoodCategory().getName()).isEqualTo(foodDto.getFoodCategory().getName());

//        foodDto.getIngredient().setId(99999L);
//        assertThat(footEntity.getIngredient().getId()).isNotEqualTo(foodDto.getIngredient().getId());
//        assertThat(foodDto.getIngredientId()).isEqualTo(99999L);
//        assertThat(foodDto.getIngredient().getId()).isEqualTo(99999L);

        foodDto.setFoodCategoryId(667L);
        assertThat(footEntity.getFoodCategory().getId()).isNotEqualTo(foodDto.getFoodCategory().getId());
        assertThat(foodDto.getFoodCategoryId()).isEqualTo(667L);
        assertThat(foodDto.getFoodCategory().getId()).isEqualTo(667L);

//        foodDto.getIngredient().setIngredientCategoryId(77777L);
//        assertThat(footEntity.getIngredient().getIngredientCategory().getId()).isNotEqualTo(foodDto.getIngredient().getIngredientCategory().getId());
//        assertThat(foodDto.getIngredient().getIngredientCategory().getId()).isEqualTo(77777L);
//        assertThat(foodDto.getIngredient().getIngredientCategoryId()).isEqualTo(77777L);

    }
}
