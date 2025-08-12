package com.mjc813.springbootwebprj.genre.controller;


import com.mjc813.springbootwebprj.genre.dto.GenreEntity;
import com.mjc813.springbootwebprj.genre.service.GenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/genre")
public class GenreRestController {

    @Autowired
    private GenreRepository genreRepository;

    @PostMapping
    public ResponseEntity<GenreEntity> insert(@RequestBody GenreEntity entity) {

        try {
            genreRepository.save(entity);
            return ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).body(entity);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GenreEntity> update(@RequestBody GenreEntity entity) {

        try {
            genreRepository.save(entity);
            return ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).body(entity);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        try {
            genreRepository.deleteById(id);
            return ResponseEntity.ok().body(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).body(id);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreEntity> findById(@PathVariable Long id) {
        try {
            Optional<GenreEntity> byId = genreRepository.findById(id);
            if (byId.isPresent()) {
                return ResponseEntity.ok().body(byId.orElse(null));
            } else {

                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<Page<GenreEntity>> findByNameContains(@RequestParam String name, Pageable pageable) {
        try {
            Page<GenreEntity> list = this.genreRepository.findByNameContains(name, pageable);
            return ResponseEntity.ok().body(list);
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(null);
        }
    }


}
