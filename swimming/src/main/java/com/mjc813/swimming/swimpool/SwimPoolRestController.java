package com.mjc813.swimming.swimpool;

//import com.mjc813.spacrud.common.ResponseDto;
import com.mjc813.swimming.common.ResponseCode;
import com.mjc813.swimming.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/swimPool")
public class SwimPoolRestController {
    @Autowired
    private SwimPoolService swimPoolService;


    @GetMapping("/list")
    public ResponseEntity<ResponseDto> loadData() {


        try {
            List<SwimPoolDto> arraylist = this.swimPoolService.findAll();
            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", arraylist));
        } catch (Throwable e) {

            log.error(e.toString());
            return ResponseEntity.status(500).body(this.getResponseDto(ResponseCode.SELECT_FAIL, "error", null));
        }
    }

    private ResponseDto getResponseDto(ResponseCode eCode, String msg, Object data) {
        return ResponseDto.builder()
                .code(eCode)
                .message(msg)
                .responseData(data)
                .build();
    }

    @GetMapping("/getone")
    public ResponseEntity<ResponseDto> findById(@RequestParam("id") Long id) {
        try {
            SwimPoolDto find = this.swimPoolService.findById(id);
            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", find));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(this.getResponseDto(ResponseCode.SELECT_FAIL, "error", null));
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseDto> insert(@RequestBody SwimPoolDto dto) {
        try {
            this.swimPoolService.addMember(dto);
            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(this.getResponseDto(ResponseCode.INSERT_FAIL, "error", dto));
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<ResponseDto> update(@RequestBody SwimPoolDto dto) {
        try {
            this.swimPoolService.update(dto);
            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(this.getResponseDto(ResponseCode.UPDATE_FAIL, "error", dto));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(@RequestBody SwimPoolDto dto) {
        try {
            this.swimPoolService.deleteById(dto.getId());
            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(this.getResponseDto(ResponseCode.DELETE_FAIL, "error", dto));
        }
    }
}
