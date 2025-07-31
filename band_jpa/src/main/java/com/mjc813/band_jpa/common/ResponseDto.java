package com.mjc813.band_jpa.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {
    private String message;
    private Integer statusCode;
    private Object data;
}