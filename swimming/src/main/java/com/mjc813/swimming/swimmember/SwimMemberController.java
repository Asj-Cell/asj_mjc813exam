package com.mjc813.swimming.swimmember;


import com.mjc813.swimming.common.ResponseCode;
import com.mjc813.swimming.common.ResponseDto;
import com.mjc813.swimming.swimpool.SwimPoolDto;
import com.mjc813.swimming.swimpool.SwimPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class SwimMemberController {

    @Autowired
    private SwimMemberService swimMemberService;

    @GetMapping("/list")
    public ResponseEntity<ResponseDto> loadData() {
        try {
            List<SwimMemberDto> arraylist = swimMemberService.findAll();
            return ResponseEntity.ok(getResponseDto(ResponseCode.SUCCESS, "ok", arraylist));
        } catch (Throwable e) {
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.SELECT_FAIL, "error", null));
        }
    }

    private ResponseDto getResponseDto(ResponseCode eCode, String msg, Object data) {
        return ResponseDto.builder()
                .code(eCode)
                .message(msg)
                .responseData(data)
                .build();
    }


    @GetMapping("findById")
    public ResponseEntity<ResponseDto> findById(@RequestParam("id") Long id) {
        try {
            SwimMemberDto find = swimMemberService.findById(id);
            return ResponseEntity.ok(getResponseDto(ResponseCode.SUCCESS, "ok", find));
        } catch (Throwable e) {
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.SELECT_FAIL, "error", null));
        }
    }

    @PostMapping
    public ResponseEntity<ResponseDto> insert(@RequestBody SwimMemberDto dto) {
        try {
            swimMemberService.addMember(dto);
            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", dto));
        } catch (Throwable e) {
            return ResponseEntity.status(500).body(this.getResponseDto(ResponseCode.INSERT_FAIL, "error", dto));
        }
    }

    @PatchMapping
    public ResponseEntity<ResponseDto> update(@RequestBody SwimMemberDto dto) {
        try {
            swimMemberService.update(dto);
            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", dto));
        } catch (Throwable e) {
            return ResponseEntity.status(500).body(this.getResponseDto(ResponseCode.UPDATE_FAIL, "error", dto));
        }
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestBody SwimMemberDto dto) {
        try {
            swimMemberService.deleteById(dto.getId());
            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", dto));
        } catch (Throwable e) {
            return ResponseEntity.status(500).body(this.getResponseDto(ResponseCode.DELETE_FAIL, "error", dto));
        }
    }

}
