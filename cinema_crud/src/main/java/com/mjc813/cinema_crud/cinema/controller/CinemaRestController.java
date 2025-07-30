package com.mjc813.cinema_crud.cinema.controller;


import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.cinema.service.CinemaMybatisMapper;
import com.mjc813.cinema_crud.cinema.service.CinemaService;
import com.mjc813.cinema_crud.common.ResponseDto;
import com.mjc813.cinema_crud.genre.dto.GenreDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/cinema")
public class CinemaRestController {

    @Autowired
    private CinemaService cinemaService;

    @PostMapping
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody CinemaDto dto) {
        try{
            cinemaService.insertCinema(dto);
            ResponseDto result = ResponseDto.builder()
                    .message("ok")
                    .resultCode(50010)
                    .resultData(dto)
                    .build();
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            log.error(e.toString());
            ResponseDto result = ResponseDto.builder()
                    .message("error")
                    .resultCode(90000)
                    .resultData(null)
                    .build();
            return ResponseEntity.status(500).body(result);
        }

    }
}
