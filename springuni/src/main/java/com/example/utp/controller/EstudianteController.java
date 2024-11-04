package com.example.utp.controller;

import com.example.utp.model.Estudiante;
import com.example.utp.service.EstudianteService;
import com.example.utp.repository.EstudianteRepository;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //rest controller es para q sea accesible atraves d un url
@RequestMapping("/api/estudiantes") //y aqui se asigna el url dentro de la pagina
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    //obtener la lista de todos los estudiantes registrados
    @GetMapping
    public List<Estudiante> getAllEstudiantes(){
        return estudianteService.getEstudiantes();
    }

    //obtener un estudiante por su id
    @GetMapping
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id){
        Estudiante estudiante = estudianteService.getEstudiante(id);
        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudiante);
    }




}
