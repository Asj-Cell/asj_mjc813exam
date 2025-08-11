package com.mjc813.food_web.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/food_category")
    public String menuFoodCategory() {
        return "/food/food_category";
    }

    @GetMapping("/ingredient_category")
    public String menuIngredientCategory() {
        return "/food/ingredient_category";
    }

    @GetMapping("/ingredient")
    public String menuIngredient() {
        return "/food/ingredient";
    }

    @GetMapping("/food")
    public String menuFood() {
        return "/food/food";
    }
}
