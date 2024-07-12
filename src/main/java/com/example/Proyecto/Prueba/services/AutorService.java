package com.example.Proyecto.Prueba.services;

import com.example.Proyecto.Prueba.dto.AutorDTO;
import com.example.Proyecto.Prueba.exceptions.EntityNotFoundException;
import com.example.Proyecto.Prueba.model.Autor;
import com.example.Proyecto.Prueba.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IAutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<AutorDTO> ListarAutores() {
        List<Autor> autores = autorRepository.findAll();
        List<AutorDTO> autoresDTOS = new ArrayList<>();
        for (Autor autor : autores){
            autoresDTOS.add(convertirAAutorDTO(autor));
        }
        return autoresDTOS;
    }

    @Override
    public Optional<AutorDTO> obtenerAutorPorId(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Autor no encontrado "));
        return Optional.of(convertirAAutorDTO(autor));
    }

    @Override
    public Optional<AutorDTO> crearAutor(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setNombre(autorDTO.getNombre());
        autor.setNacionalidad(autorDTO.getNacionalidad());
        autor = autorRepository.save(autor);
        return Optional.of(convertirAAutorDTO(autor));
    }

    @Override
    public Optional<AutorDTO> actualizarAutor(Long id, AutorDTO autorDto) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Autor no encontrado "));
        autor.setNombre(autorDto.getNombre());
        autor.setNacionalidad(autorDto.getNacionalidad());
        autor = autorRepository.save(autor);
        return Optional.of(convertirAAutorDTO(autor));

    }

    @Override
    public void eliminarAutor(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new EntityNotFoundException("Autor no encontrado");
        }
        autorRepository.deleteById(id);
    }

    AutorDTO convertirAAutorDTO(Autor autor){
        AutorDTO dto = new AutorDTO();
        dto.setIdautor(autor.getIdautor());
        dto.setNombre(autor.getNombre());
        dto.setNacionalidad(autor.getNacionalidad());
        return dto;
    }
}
