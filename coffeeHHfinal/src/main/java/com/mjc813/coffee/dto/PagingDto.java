package com.mjc813.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagingDto {
    private Integer rows; // 줄 수
    private Integer page; // 페이지수
    private Integer off; // // 단위 페이지 지점?
    private String keyWord; // 키워드

    public Integer getOff(){
        return (getPage()-1) * getRows();
    }
}
