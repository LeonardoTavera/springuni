package com.example.utp.service;

import com.example.utp.model.Estudiante;
import com.example.utp.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteService {

    @Autowired //amo y señor q nos facilita el codigo
    private EstudianteRepository estudianteRepository;

    //Creamos metodo para obtener todos los estudiantes de una lista
    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }

    //Creamos metodo para obtener estudiante por su id
    public Estudiante getEstudiante(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    //Este metodo es para registrar un estudiante
    public Estudiante saveEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    //Este metodo nos permite editar un estudiante
    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {
        Estudiante estudianteActual = estudianteRepository.findById(id).orElse(null);

        if (estudianteActual != null) {
            estudianteActual.setNombre(estudiante.getNombre());
            estudianteActual.setApellido(estudiante.getApellido());
            estudianteActual.setEmail(estudiante.getEmail());
            estudianteRepository.save(estudianteActual);
            return estudianteActual;
        } else {
            return null;
        }
    }




}
