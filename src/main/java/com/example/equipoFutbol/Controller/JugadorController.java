package com.example.equipoFutbol.Controller;

import com.example.equipoFutbol.Model.Jugador;
import com.example.equipoFutbol.Service.JugadorService;
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
}

