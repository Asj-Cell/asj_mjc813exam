package com.mjc813.mpacrud.animal.mybatis;

import com.mjc813.mpacrud.animal.dto.AnimalDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnimalMybatisMapper {
    void insert(AnimalDto animalDto);
    List<AnimalDto> findAll();
    void update(AnimalDto animalDto);
    void delete(AnimalDto animalDto);
}

