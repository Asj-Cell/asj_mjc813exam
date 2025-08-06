package com.mjc813.food_web.ingredient_category.controller;

import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import com.mjc813.food_web.ingredient_category.service.IngredientCategoryRepository;
import com.mjc813.food_web.ingredient_category.service.IngredientCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ingredient_category")
public class IngredientCategoryRestController {
    @Autowired
    private IngredientCategoryService ingredientCategoryService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@RequestBody IngredientCategoryDto dto){
        try {
            this.ingredientCategoryService.insert(dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, dto));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll(){
        try{
            List<IngredientCategoryEntity> list = this.ingredientCategoryService.findAll();
            return ResponseEntity.ok(new ResponseDto("success", 10000, list));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable("id") Long id){
        try{
            IngredientCategoryEntity entity = this.ingredientCategoryService.findById(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, entity));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable("id") Long id, @RequestBody IngredientCategoryDto dto){
        try{
            dto.setId(id);
            this.ingredientCategoryService.update(dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") Long id){
        try{
            this.ingredientCategoryService.delete(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, id));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }
}
