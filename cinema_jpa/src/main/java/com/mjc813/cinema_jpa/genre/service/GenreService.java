package com.mjc813.cinema_jpa.genre.service;


import com.mjc813.cinema_jpa.genre.dto.GenreDto;
import com.mjc813.cinema_jpa.genre.dto.GenreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public GenreEntity insert(GenreDto dto) {
        GenreEntity entity = new GenreEntity(null, dto.getName());
        genreRepository.save(entity);
        return entity;
    }

    public List<GenreEntity> findGenre(){
        return this.genreRepository.findAll();
    }
    public void update(GenreDto genreDto){
        GenreEntity entity = new GenreEntity(genreDto.getId(), genreDto.getName());
        this.genreRepository.save(entity);
    }
    public void delete(Long id){
        this.genreRepository.deleteById(id);
    }

}
