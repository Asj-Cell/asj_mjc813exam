package com.mjc813.food_web.ingredient.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "IngredientEntity")
@Table(name = "ingredient_tbl")
@Builder
public class IngredientEntity implements IIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    // `@Transient` 필드는 실제 DB 칼럼이 아니므로 그대로 유지합니다.
    @Transient
    private Long ingredientCategoryId;

    // `IngredientCategoryEntity`와의 관계를 `@ManyToOne`으로 정의합니다.
    // `fetch = FetchType.LAZY`를 통해 지연 로딩을 설정하여 성능을 최적화합니다.
    // `@JoinColumn`은 외래키 칼럼 이름을 명시하고, `nullable = false`로 필수값을 설정합니다.
    @JsonIgnore // <-- This is the key change.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_category_id", nullable = false)
    private IngredientCategoryEntity ingredientCategoryEntity;

    @Override
    public IIdName getIngredientCategory() {
        return this.ingredientCategoryEntity;
    }

    @Override
    public void setIngredientCategory(IIdName ingredientCategory) {
        if (ingredientCategory == null) {
            this.ingredientCategoryEntity = null;
            this.ingredientCategoryId = null;
            return;
        }
        if (this.ingredientCategoryEntity == null) {
            this.ingredientCategoryEntity = new IngredientCategoryEntity();
        }
        // `copyMembersIdName` 메서드를 이용해 ID와 이름을 복사합니다.
        this.ingredientCategoryEntity.copyMembersIdName(ingredientCategory);
        // `@Transient` 필드에 ID를 동기화합니다.
        this.ingredientCategoryId = ingredientCategory.getId();
    }

    @Override
    public Long getIngredientCategoryId() {
        // `ingredientCategoryEntity`가 존재하면 그 객체의 ID를 반환합니다.
        // DTO에서만 사용되는 `ingredientCategoryId` 필드가 아닌, 실제 연관관계 객체의 ID를 우선적으로 반환합니다.
        if (this.ingredientCategoryEntity != null) {
            return this.ingredientCategoryEntity.getId();
        }
        // 만약 연관관계 객체가 로딩되지 않았다면 `@Transient` 필드의 값을 반환합니다.
        return this.ingredientCategoryId;
    }

    @Override
    public void setIngredientCategoryId(Long ingredientCategoryId) {
        // ID 값이 없으면 처리하지 않습니다.
        if (ingredientCategoryId == null) {
            return;
        }
        // `@Transient` 필드와 연관관계 객체의 ID를 모두 설정합니다.
        // `ingredientCategoryEntity`가 null이면 새로운 객체를 생성합니다.
        if (this.ingredientCategoryEntity == null) {
            this.ingredientCategoryEntity = new IngredientCategoryEntity();
        }
        this.ingredientCategoryEntity.setId(ingredientCategoryId);
        this.ingredientCategoryId = ingredientCategoryId;
    }
}