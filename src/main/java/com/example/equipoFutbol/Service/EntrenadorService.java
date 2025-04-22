package com.example.equipoFutbol.Service;

import com.example.equipoFutbol.Model.Entrenador;
import com.example.equipoFutbol.Repository.EntrenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public Entrenador guardarEntrenador(Entrenador entrenador) {
        try {
            if (entrenador.getNombre() == null || entrenador.getNombre().trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre del entrenador no puede estar vacío.");
            }
            return entrenadorRepository.save(entrenador);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el entrenador: " + e.getMessage(), e);
        }
    }

    public List<Entrenador> listarEntrenadores() {
        try {
            return entrenadorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los entrenadores: " + e.getMessage(), e);
        }
    }

    public void eliminarEntrenador(int id_entrenador) {
        try {
            if (!entrenadorRepository.existsById(id_entrenador)) {
                throw new IllegalArgumentException("No se encontró un entrenador con el ID " + id_entrenador);
            }
            entrenadorRepository.deleteById(id_entrenador);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el entrenador: " + e.getMessage(), e);
        }
    }

    public Optional<Entrenador> listarEntrenadorPorId(int id_entrenador) {
        try {
            return entrenadorRepository.findById(id_entrenador);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el entrenador por ID: " + e.getMessage(), e);
        }
    }
}
