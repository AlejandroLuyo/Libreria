package com.example.Proyecto.Prueba.services;

import com.example.Proyecto.Prueba.model.Libro;

import java.util.List;

public interface ILibroService {
    public List<Libro>listarLibros();
    public Libro obtenerLibroPorId(Long id);
    public Libro registrarLibro(Libro libro);
    public Libro actualizarLibro(Libro libro);
    public void eliminarLibro (Long id);
}
