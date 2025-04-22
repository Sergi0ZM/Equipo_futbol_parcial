package com.example.equipoFutbol.Controller;

import com.example.equipoFutbol.Model.Entrenador;
import com.example.equipoFutbol.Service.EntrenadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {
    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }
    @PostMapping
    public Entrenador guardarEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.guardarEntrenador(entrenador);
    }

    @GetMapping
    public List<Entrenador> listarEntrenadores() {
        return entrenadorService.listarEntrenadores();
    }

    @GetMapping("/{id}")
    public Optional<Entrenador> obtenerEntrenadorPorId(@PathVariable int id) {
        return entrenadorService.listarEntrenadorPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarEntrenador(@PathVariable int id) {
        entrenadorService.eliminarEntrenador(id);
    }
}

