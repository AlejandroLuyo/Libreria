package com.example.Proyecto.Prueba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idlibro;

    private String titulo;
    private int isbn;
    private LocalDate fechapublicacion;

    @ManyToOne
    @JoinColumn(name = "idautor")
    private Autor autor;
}
