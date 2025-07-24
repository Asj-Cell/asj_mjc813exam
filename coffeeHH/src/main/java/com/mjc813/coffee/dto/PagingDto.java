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
    private Integer rows;
    private Integer page;
    private Integer off;

    public Integer getOff(){
        return (getPage()-1) * getRows();
    }
}
