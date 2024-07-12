package com.example.Proyecto.Prueba.services;

import com.example.Proyecto.Prueba.dto.AutorDTO;
import com.example.Proyecto.Prueba.model.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    List<AutorDTO> ListarAutores();
    Optional<AutorDTO>obtenerAutorPorId(Long id);
    Optional<AutorDTO>crearAutor(AutorDTO autorDTO);
    Optional<AutorDTO>actualizarAutor(Long id, AutorDTO autorDto);
    void eliminarAutor(Long id);
}
