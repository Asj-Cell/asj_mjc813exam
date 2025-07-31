package com.mjc813.cinema_crud.cinema.service;


import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.cinema.dto.CinemaGenreDto;
import com.mjc813.cinema_crud.genre.dto.GenreDto;
import com.mjc813.cinema_crud.genre.service.GenreMybatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaMybatisMapper cinemaMybatisMapper;

    @Autowired
    private GenreMybatisMapper genreMybatisMapper;

    public void insertCinema(CinemaDto cinemaDto){
        cinemaMybatisMapper.insertCinema(cinemaDto);
    }

    @Transactional
    public void insertCinemaWithGento(CinemaGenreDto dto) {
        GenreDto genreDto = new GenreDto();
        genreDto.setName(dto.getGenre());

        CinemaDto cinemaDto = new CinemaDto();
        cinemaDto.setName(dto.getName());
        cinemaDto.setCasts(dto.getCasts());
        cinemaDto.setPlayTime(dto.getPlayTime());
        cinemaDto.setDescription(dto.getDescription());
        cinemaDto.setRestrictAge(dto.getRestrictAge());

        this.genreMybatisMapper.insert(genreDto);
        cinemaDto.setGenreId(genreDto.getId());

        this.cinemaMybatisMapper.insertCinema(cinemaDto);
        dto.setId(cinemaDto.getId());
    }

    public CinemaDto findById(Long id){
        return cinemaMybatisMapper.findById(id);

    }

    public List<CinemaGenreDto> findByWhere(){
        return cinemaMybatisMapper.findByWhere();
    }

    public void update(CinemaDto cinemaDto){
        cinemaMybatisMapper.update(cinemaDto);
    }

    public void delete(Long id){
        cinemaMybatisMapper.delete(id);
    }
}
