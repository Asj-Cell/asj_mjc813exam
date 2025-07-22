package com.mjc813.coffeecrud.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CoffeeDto {

    private Integer id;
    private String name;
    private Long price;
    private String source;
    private String shots;


}
