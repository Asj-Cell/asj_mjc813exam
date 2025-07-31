package com.mjc813.cinema_crud.cinema.service;

import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.cinema.dto.CinemaGenreDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CinemaMybatisMapper {
    void insertCinema(CinemaDto cinemaDto);
    CinemaDto findById(Long id);

    List<CinemaGenreDto> findByWhere();

    void update(CinemaDto cinemaDto);
    void delete(Long id);
}
