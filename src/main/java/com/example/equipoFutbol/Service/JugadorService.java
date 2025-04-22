package com.example.equipoFutbol.Service;

import com.example.equipoFutbol.Model.Jugador;
import com.example.equipoFutbol.Repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public Jugador guardarJugador(Jugador jugador) {
        try {
            if (jugador.getNombre() == null || jugador.getNombre().trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre del jugador no puede estar vacío.");
            }
            if (jugador.getPosicion() == null || jugador.getPosicion().trim().isEmpty()) {
                throw new IllegalArgumentException("La posición no puede estar vacía.");
            }
            return jugadorRepository.save(jugador);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el jugador: " + e.getMessage(), e);
        }
    }

    public List<Jugador> listarJugadores() {
        try {
            return jugadorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los jugadores: " + e.getMessage(), e);
        }
    }

    public void eliminarJugador(int id_jugador) {
        try {
            if (!jugadorRepository.existsById(id_jugador)) {
                throw new IllegalArgumentException("No se encontró un jugador con el ID " + id_jugador);
            }
            jugadorRepository.deleteById(id_jugador);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el jugador: " + e.getMessage(), e);
        }
    }

    public Optional<Jugador> listarJugadorPorId(int id_jugador) {
        try {
            return jugadorRepository.findById(id_jugador);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el jugador por ID: " + e.getMessage(), e);
        }
    }
}
