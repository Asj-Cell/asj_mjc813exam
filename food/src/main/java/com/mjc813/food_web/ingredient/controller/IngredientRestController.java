package com.mjc813.food_web.ingredient.controller;

import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.food.controller.FoodRestController;
import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.service.FoodService;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.ingredient.dto.IngredientDto;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import com.mjc813.food_web.ingredient.service.IngredientService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/ingredient")
public class IngredientRestController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody IngredientDto dto){
        try{
            this.ingredientService.insert(dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }
    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll(){
        try{
            List<IngredientEntity> list = this.ingredientService.findAll();
            return ResponseEntity.ok(new ResponseDto("success", 10000, list));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable("id") Long id){
        try{
            IngredientEntity entity = this.ingredientService.findById(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, entity));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@Validated @PathVariable("id") Long id, @RequestBody IngredientDto dto){
        try{
            dto.setId(id);
            this.ingredientService.update(dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") Long id){
        try{
            this.ingredientService.delete(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, id));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }
}
