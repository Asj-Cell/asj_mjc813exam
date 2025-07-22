package com.mjc813.coffeecrud.coffee.service;


import com.mjc813.coffeecrud.coffee.dto.CoffeeDto;
import com.mjc813.coffeecrud.coffee.mybatis.CoffeeMybatisMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeMybatisMapper coffeeMybatisMapper;

    public CoffeeService(CoffeeMybatisMapper coffeeMybatisMapper) {
        this.coffeeMybatisMapper = coffeeMybatisMapper;
    }

    public void insert(CoffeeDto coffeeDto){
        coffeeMybatisMapper.insert(coffeeDto);
    }

    public List<CoffeeDto> findAll(){
        return coffeeMybatisMapper.findAll();
    }

    public CoffeeDto findById(Integer id){
        return coffeeMybatisMapper.findById(id);
    }

    public void update(CoffeeDto coffeeDto){
        coffeeMybatisMapper.update(coffeeDto);
    }
    public void delete(CoffeeDto coffeeDto){
        coffeeMybatisMapper.delete(coffeeDto);
    }
}
