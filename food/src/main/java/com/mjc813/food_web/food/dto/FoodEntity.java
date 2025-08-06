package com.mjc813.food_web.food.dto;


import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.ingredient.dto.IngredientDto;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="food_tbl")
public class FoodEntity implements IFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Max(10)
    private Integer spicyLevel;

    @Max(10)
	private Integer sweetLevel;

    @Max(10)
    private Integer sourLevel;

    @Max(10)
    private Integer saltyLevel;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredient;

    @ManyToOne
    @JoinColumn(name = "food_category_id")
    private FoodCategoryEntity foodCategory;

    @Override
    public Long getIngredientId() {
        if(this.ingredient == null){
            return 0L;
        }
        return this.ingredient.getId();
    }

    @Override
    public Long getFoodCategoryId() {
        if(this.foodCategory == null){
            return 0L;
        }
        return this.foodCategory.getId();
    }

    @Override
    public void setIngredientId(Long ingredientId) {
        if(this.ingredient == null){
            return;
        }
        this.ingredient.setId(ingredientId);
    }

    @Override
    public void setFoodCategoryId(Long foodCategoryId) {
        if(this.foodCategory == null){
            return;
        }
        this.foodCategory.setId(foodCategoryId);
    }
}
