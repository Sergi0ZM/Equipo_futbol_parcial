package com.example.equipoFutbol.Controller;

import com.example.equipoFutbol.Model.Jugador;
import com.example.equipoFutbol.Service.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }
    @PostMapping
    public Jugador guardarJugador(@RequestBody Jugador jugador) {
        return jugadorService.guardarJugador(jugador);
    }

    @GetMapping
    public List<Jugador> listarJugadores() {
        return jugadorService.listarJugadores();
    }

    @GetMapping("/{id}")
    public Optional<Jugador> obtenerJugadorPorId(@PathVariable int id) {
        return jugadorService.listarJugadorPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarJugador(@PathVariable int id) {
        jugadorService.eliminarJugador(id);
    }
    @GetMapping("/equipo/{id}")
    public ResponseEntity<List<Jugador>> obtenerJugadoresPorEquipo(@PathVariable("id") int idEquipo) {
        try {
            List<Jugador> jugadores = jugadorService.obtenerJugadoresPorEquipo(idEquipo);
            return ResponseEntity.ok(jugadores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/goles/{min}")
    public ResponseEntity<List<Jugador>> jugadoresConMasDeXGoles(@PathVariable("min") int golesMinimos) {
        try {
            List<Jugador> jugadores = jugadorService.obtenerJugadoresConMasDeXGoles(golesMinimos);
            return ResponseEntity.ok(jugadores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}

