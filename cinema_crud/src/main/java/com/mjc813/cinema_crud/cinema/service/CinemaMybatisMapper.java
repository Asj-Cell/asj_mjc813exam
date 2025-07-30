package com.mjc813.cinema_crud.cinema.service;

import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CinemaMybatisMapper {
    void insertCinema(CinemaDto cinemaDto);
}
