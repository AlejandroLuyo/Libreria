package com.example.Proyecto.Prueba.services;

import com.example.Proyecto.Prueba.exceptions.EntityNotFoundException;
import com.example.Proyecto.Prueba.model.Libro;
import com.example.Proyecto.Prueba.repositories.LibroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> listarLibros() {
        return (List<Libro>)libroRepository.findAll();
    }

    @Override
    public Libro obtenerLibroPorId(Long id) {
        return libroRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("Libro no encontrado con id "+ id)
        );
    }

    @Override
    public Libro registrarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizarLibro(Libro libro) {
        return libroRepository.findById(libro.getIdlibro()).map(librodb -> {
                    librodb.setAutor(libro.getAutor());
                    librodb.setTitulo(libro.getTitulo());
                    librodb.setIsbn(libro.getIsbn());
                    librodb.setFechapublicacion(libro.getFechapublicacion());
                    return libroRepository.save(librodb);
                })
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con id " + libro.getIdlibro()));
    }

    @Override
    public void eliminarLibro(Long id) {
        Libro librodb = libroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con id " + id));
        libroRepository.delete(librodb);
    }
}
