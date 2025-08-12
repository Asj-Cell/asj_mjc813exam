package com.mjc813.springbootwebprj.song.dto;

import com.mjc813.springbootwebprj.genre.dto.GenreEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
@Table(name = "song_tb")
@Entity
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String title;

    @ManyToOne
    @JoinColumn(name = "genre_id",nullable = false)
    private GenreEntity genre;

    @Column(nullable = false, length = 50)
    private String composer;

    @Column(nullable = false, length = 50)
    private String artist;

    private LocalDate releaseDate;

}
