package com.example.equipoFutbol.Service;

import com.example.equipoFutbol.Model.Estadisticas_jugador;
import com.example.equipoFutbol.Repository.Estadisticas_jugador_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticasJugadorService {

    private final Estadisticas_jugador_repository estadisticasRepository;

    public EstadisticasJugadorService(Estadisticas_jugador_repository estadisticasRepository) {
        this.estadisticasRepository = estadisticasRepository;
    }

    public Estadisticas_jugador guardarEstadistica(Estadisticas_jugador estadistica) {
        try {
            return estadisticasRepository.save(estadistica);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la estadística: " + e.getMessage(), e);
        }
    }

    public List<Estadisticas_jugador> listarEstadisticas() {
        try {
            return estadisticasRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar las estadísticas: " + e.getMessage(), e);
        }
    }

    public void eliminarEstadistica(int id_estadistica) {
        try {
            if (!estadisticasRepository.existsById(id_estadistica)) {
                throw new IllegalArgumentException("No se encontró una estadística con el ID " + id_estadistica);
            }
            estadisticasRepository.deleteById(id_estadistica);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la estadística: " + e.getMessage(), e);
        }
    }

    public Optional<Estadisticas_jugador> listarEstadisticaPorId(int id_estadistica) {
        try {
            return estadisticasRepository.findById(id_estadistica);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la estadística por ID: " + e.getMessage(), e);
        }
    }
}
