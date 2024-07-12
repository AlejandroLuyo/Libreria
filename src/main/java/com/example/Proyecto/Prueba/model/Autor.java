package com.example.Proyecto.Prueba.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idautor;

    private String nombre;
    private String nacionalidad;

    @OneToMany(mappedBy = "autor")
    @JsonIgnoreProperties("autor")
    private Set<Libro> libros;
}
