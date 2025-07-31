package com.mjc813.cinema_crud.cinema.controller;


import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.cinema.dto.CinemaGenreDto;
import com.mjc813.cinema_crud.cinema.service.CinemaService;
import com.mjc813.cinema_crud.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/genre")
    public ResponseEntity<ResponseDto> insert2Genre(@RequestBody CinemaGenreDto dto) {
        try {
            this.cinemaService.insertCinemaWithGento(dto);
            return ResponseEntity.ok().body(
                    new ResponseDto("ok", 50010, dto)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    new ResponseDto("insert error", 90000, dto)
            );
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try{
            CinemaDto find = cinemaService.findById(id);
            if (find == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(
                    new ResponseDto("ok",40010,find));
        }catch (Exception e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    new ResponseDto("insert error", 90000, id)
            );
        }

    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDto> findByWhere() {
        try{
            List<CinemaGenreDto> list = cinemaService.findByWhere();
            return ResponseEntity.ok().body(
                    new ResponseDto("ok",40050,list));
        }catch (Exception e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    new ResponseDto("findByWhere error", 90000, null)
            );
        }
    }

    @PatchMapping
    public ResponseEntity<ResponseDto> update(@Validated @RequestBody CinemaDto dto) {
        try{
            cinemaService.update(dto);
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

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestBody CinemaDto dto) {
        try{
            cinemaService.delete(dto.getId());
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
