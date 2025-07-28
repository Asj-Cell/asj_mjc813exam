package com.mjc813.coffee.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeDto {
    private Long id;
    private String name;
    private Integer price;
    private String source;
    private String shots;
}