package com.mjc813.band_jpa.band.controller;
import com.mjc813.band_jpa.band.dto.BandDto;
import com.mjc813.band_jpa.band.dto.BandEntity;
import com.mjc813.band_jpa.band.service.BandService;
import com.mjc813.band_jpa.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/band")
public class BandRestController {

    @Autowired
    private BandService bandService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@RequestBody BandDto bandDto){
        try {
            this.bandService.insert(bandDto);
            return ResponseEntity.ok(new ResponseDto("insert success", 1000, bandDto));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("insert fail", 9000, null));
        }
    }
    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll(){
        try {
            List<BandEntity> list = this.bandService.findAll();
            return ResponseEntity.ok(new ResponseDto("findAll success", 1000, list));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("findAll fail", 9000, null));
        }
    }
    @PatchMapping("")
    public ResponseEntity<ResponseDto> update(@RequestBody BandDto bandDto){
        try {
            this.bandService.update(bandDto);
            return ResponseEntity.ok(new ResponseDto("update success", 1000, bandDto));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("update fail", 9000, null));
        }
    }
    @DeleteMapping("")
    public ResponseEntity<ResponseDto> delete(@RequestBody BandDto bandDto){
        try {
            this.bandService.delete(bandDto.getId());
            return ResponseEntity.ok(new ResponseDto("delete success", 1000, bandDto.getId()));
        }catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.status(500).body(new ResponseDto("delete fail", 9000, null));
        }
    }


}
