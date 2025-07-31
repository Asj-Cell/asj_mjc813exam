package com.mjc813.band_jpa.band.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BandDto {

    private Long id;
    private String name;
    private String leader;
    private String guitarFirst;
    private String guitarSecond;
    private String drum;
    private String bass;
    private String keyboard;
    private String vocal;
}
