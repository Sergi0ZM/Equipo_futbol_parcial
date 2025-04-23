package com.example.equipoFutbol.Controller;

import com.example.equipoFutbol.Model.Estadisticas_jugador;
import com.example.equipoFutbol.Service.EstadisticasJugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasJugadorController {

    private final EstadisticasJugadorService estadisticasJugadorService;

    public EstadisticasJugadorController(EstadisticasJugadorService estadisticasJugadorService) {
        this.estadisticasJugadorService = estadisticasJugadorService;
    }
    @PostMapping
    public Estadisticas_jugador guardarEstadisticas(@RequestBody Estadisticas_jugador estadistica) {
        return estadisticasJugadorService.guardarEstadistica(estadistica);
    }

    @GetMapping
    public List<Estadisticas_jugador> listarEstadisticas() {
        return estadisticasJugadorService.listarEstadisticas();
    }

    @GetMapping("/{id}")
    public Optional<Estadisticas_jugador> obtenerEstadisticaPorId(@PathVariable int id) {
        return estadisticasJugadorService.listarEstadisticaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstadistica(@PathVariable int id) {
        estadisticasJugadorService.eliminarEstadistica(id);
    }
}
