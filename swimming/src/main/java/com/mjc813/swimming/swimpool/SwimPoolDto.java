package com.mjc813.swimming.swimpool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SwimPoolDto {

    private Long id;
    private String name;
    private Integer ranes;
    private Integer raneType;
    private String phoneNumber;
    private String addr;
}

