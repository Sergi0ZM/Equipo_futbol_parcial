package com.example.equipoFutbol.Service;

import com.example.equipoFutbol.Model.Equipo;
import com.example.equipoFutbol.Repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public Equipo guardarEquipo(Equipo equipo) {
        try {
            if (equipo.getNombre() == null || equipo.getNombre().trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre del equipo no puede estar vacío.");
            }
            if (equipo.getCiudad() == null || equipo.getCiudad().trim().isEmpty()) {
                throw new IllegalArgumentException("La ciudad del equipo no puede estar vacía.");
            }
            return equipoRepository.save(equipo);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el equipo: " + e.getMessage(), e);
        }
    }

    public List<Equipo> listarEquipos() {
        try {
            return equipoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los equipos: " + e.getMessage(), e);
        }
    }

    public void eliminarEquipo(int id_equipo) {
        try {
            if (!equipoRepository.existsById(id_equipo)) {
                throw new IllegalArgumentException("No se encontró un equipo con el ID " + id_equipo);
            }
            equipoRepository.deleteById(id_equipo);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el equipo: " + e.getMessage(), e);
        }
    }

    public Optional<Equipo> listarEquipoPorId(int id_equipo) {
        try {
            return equipoRepository.findById(id_equipo);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el equipo por ID: " + e.getMessage(), e);
        }
    }
}
