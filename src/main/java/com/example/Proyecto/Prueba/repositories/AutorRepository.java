package com.example.Proyecto.Prueba.repositories;

import com.example.Proyecto.Prueba.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
}
