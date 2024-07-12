package com.example.Proyecto.Prueba.repositories;

import com.example.Proyecto.Prueba.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
    Libro findByAutorId(Long id);
}
