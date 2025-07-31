package com.mjc813.cinema_jpa.genre.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "GenreEntity")
@Table(name = "genre2_tbl")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


}
