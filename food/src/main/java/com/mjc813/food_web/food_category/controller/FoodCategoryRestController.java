package com.mjc813.food_web.food_category.controller;

import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.food_category.service.FoodCategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/food_category")
public class FoodCategoryRestController {

    @Autowired
    private FoodCategoryService foodCategoryService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody FoodCategoryDto dto){
        try{
            this.foodCategoryService.insert(dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll(){
        try{
            List<FoodCategoryEntity> list = this.foodCategoryService.findAll();
            return ResponseEntity.ok(new ResponseDto("success", 10000, list));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable("id") Long id){
        try{
            FoodCategoryEntity entity = this.foodCategoryService.findById(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, entity));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@Validated @PathVariable("id") Long id, @RequestBody FoodCategoryDto dto){
        try{
            dto.setId(id);
            this.foodCategoryService.update(dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") Long id){
        try{
            this.foodCategoryService.delete(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, id));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("error", 90000, e));
        }
    }
}
