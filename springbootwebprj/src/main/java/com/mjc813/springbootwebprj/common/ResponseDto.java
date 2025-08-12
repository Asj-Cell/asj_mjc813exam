package com.mjc813.springbootwebprj.common;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDto {

    private Integer resultCode;
    private String message;
    private Object resultDate;

}
