package com.example.equipoFutbol.Service;

import com.example.equipoFutbol.Model.Partido;
import com.example.equipoFutbol.Repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    private final PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public Partido guardarPartido(Partido partido) {
        try {
            if (partido.getEstadio() == null || partido.getEstadio().trim().isEmpty()) {
                throw new IllegalArgumentException("El estadio no puede estar vacío.");
            }
            return partidoRepository.save(partido);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el partido: " + e.getMessage(), e);
        }
    }

    public List<Partido> listarPartidos() {
        try {
            return partidoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los partidos: " + e.getMessage(), e);
        }
    }

    public void eliminarPartido(int id_partido) {
        try {
            if (!partidoRepository.existsById(id_partido)) {
                throw new IllegalArgumentException("No se encontró un partido con el ID " + id_partido);
            }
            partidoRepository.deleteById(id_partido);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el partido: " + e.getMessage(), e);
        }
    }

    public Optional<Partido> listarPartidoPorId(int id_partido) {
        try {
            return partidoRepository.findById(id_partido);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el partido por ID: " + e.getMessage(), e);
        }
    }
    public List<Object[]> obtenerResultadosConNombresEquipos() {
        return partidoRepository.obtenerResultadosConNombresEquipos();
    }

}
