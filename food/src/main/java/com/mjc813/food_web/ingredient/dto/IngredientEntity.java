package com.mjc813.food_web.ingredient.dto;

import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredient_tbl")
public class IngredientEntity implements IIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "ingredient_category_id")
    private IngredientCategoryEntity ingredientCategory;

    @Override
    public Long getIngredientCategoryId() {
        if(this.ingredientCategory == null){
            return 0L;
        }
        return this.ingredientCategory.getId();
    }

    @Override
    public void setIngredientCategoryId(Long categoryId) {
        if(this.ingredientCategory == null){
            return;
        }
        this.ingredientCategory.setId(categoryId);
    }
}
