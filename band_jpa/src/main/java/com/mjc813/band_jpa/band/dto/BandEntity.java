package com.mjc813.band_jpa.band.dto;


import jakarta.persistence.*;
import lombok.*;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "BandEntity")
@Table(name ="band_tbl")
public class BandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "leader")
    private String leader;

    @Column(name = "guitar_first")
    private String guitarFirst;

    @Column(name = "guitar_second")
    private String guitarSecond;

    @Column(name = "drum")
    private String drum;

    @Column(name = "bass")
    private String bass;

    @Column(name = "keyboard")
    private String keyboard;

    @Column(name = "vocal")
    private String vocal;

}
