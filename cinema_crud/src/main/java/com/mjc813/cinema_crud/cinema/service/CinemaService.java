package com.mjc813.cinema_crud.cinema.service;


import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    @Autowired
    private CinemaMybatisMapper cinemaMybatisMapper;

    public void insertCinema(CinemaDto cinemaDto){
        cinemaMybatisMapper.insertCinema(cinemaDto);
    }
}
