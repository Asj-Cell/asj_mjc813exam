package com.mjc813.coffeecrud.coffee.mybatis;

import com.mjc813.coffeecrud.coffee.dto.CoffeeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoffeeMybatisMapper {

    void insert(CoffeeDto animalDto);
    List<CoffeeDto> findAll();
    void update(CoffeeDto animalDto);
    void delete(CoffeeDto animalDto);
    CoffeeDto findById(Integer id);
}
