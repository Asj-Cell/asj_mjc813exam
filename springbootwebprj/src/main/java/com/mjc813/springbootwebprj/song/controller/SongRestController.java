package com.mjc813.springbootwebprj.song.controller;

import com.mjc813.springbootwebprj.common.ResponseDto;
import com.mjc813.springbootwebprj.genre.dto.GenreEntity;
import com.mjc813.springbootwebprj.song.dto.SongEntity;
import com.mjc813.springbootwebprj.song.service.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/song")
public class SongRestController {

    @Autowired
    private SongRepository songRepository;


    @PostMapping
    public ResponseEntity<ResponseDto> insert(@RequestBody SongEntity entity) {
        try {
            songRepository.save(entity);

            return ResponseEntity.ok().body(ResponseDto.builder()
                    .resultCode(999)
                    .message("SUCCESS")
                    .resultDate(entity)
                    .build());
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                            .resultCode(999)
                            .message("EEROR")
                            .resultDate(entity)
                            .build());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@RequestBody SongEntity entity) {
        try {
            songRepository.save(entity);

            return ResponseEntity.ok().body(ResponseDto.builder()
                    .resultCode(999)
                    .message("SUCCESS")
                    .resultDate(entity)
                    .build());
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                    .resultCode(999)
                    .message("EEROR")
                    .resultDate(entity)
                    .build());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        try {
            songRepository.deleteById(id);

            return ResponseEntity.ok().body(ResponseDto.builder()
                    .resultCode(999)
                    .message("SUCCESS")
                    .resultDate(id)
                    .build());
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                    .resultCode(999)
                    .message("EEROR")
                    .resultDate(id)
                    .build());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            Optional<SongEntity> byId = songRepository.findById(id);
            if (byId.isPresent()) {
                return ResponseEntity.ok().body(ResponseDto.builder()
                        .resultCode(999)
                        .message("SUCCESS")
                        .resultDate(byId)
                        .build());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                    .resultCode(999)
                    .message("EEROR")
                    .resultDate(id)
                    .build());
        }
    }


    @GetMapping("")
    public ResponseEntity<ResponseDto> findByArtistContainingAndTitleContaining(@RequestParam String artist,@RequestParam String title, Pageable pageable) {
        try {
            Page<SongEntity> list = songRepository.findByTitleOrArtistContains(artist, title, pageable);
                return ResponseEntity.ok().body(ResponseDto.builder()
                        .resultCode(999)
                        .message("SUCCESS")
                        .resultDate(list)
                        .build());
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(ResponseDto.builder()
                    .resultCode(999)
                    .message("EEROR")
                    .resultDate(artist)
                    .build());
        }
    }





















}
