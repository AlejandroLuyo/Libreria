package com.example.Proyecto.Prueba.controller;

import com.example.Proyecto.Prueba.dto.AutorDTO;
import com.example.Proyecto.Prueba.services.IAutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/autor")
public class AutorController {

    private IAutorService autorService;

    @GetMapping("")
    public ResponseEntity<List<AutorDTO>> listarAutores(){
        List<AutorDTO> autores = autorService.ListarAutores();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> obtenerAutorPorID(@PathVariable Long id){
        return autorService.obtenerAutorPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AutorDTO> crearAutor(@RequestBody AutorDTO autorDTO){
        return autorService.crearAutor(autorDTO)
                .map(au -> ResponseEntity.status(HttpStatus.CREATED).body(au))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PutMapping("/{id}")
    public  ResponseEntity<AutorDTO> actualizarAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO){
        return autorService.actualizarAutor(id,autorDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable Long id) {
        autorService.eliminarAutor(id);
        return ResponseEntity.noContent().build();
    }

}
