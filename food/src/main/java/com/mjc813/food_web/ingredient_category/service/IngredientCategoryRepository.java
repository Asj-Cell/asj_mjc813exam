package com.mjc813.food_web.ingredient_category.service;

import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="api_ingredient")
public interface IngredientCategoryRepository extends JpaRepository<IngredientCategoryEntity, Long> {
}
