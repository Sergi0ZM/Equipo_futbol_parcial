package com.example.equipoFutbol.Controller;

import com.example.equipoFutbol.Model.Equipo;
import com.example.equipoFutbol.Service.EquipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping
    public Equipo guardarEquipo(@RequestBody Equipo equipo) {
        return equipoService.guardarEquipo(equipo);
    }

    @GetMapping
    public List<Equipo> listarEquipos() {
        return equipoService.listarEquipos();
    }

    @GetMapping("/{id}")
    public Optional<Equipo> obtenerEquipoPorId(@PathVariable int id) {
        return equipoService.listarEquipoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarEquipo(@PathVariable int id) {
        equipoService.eliminarEquipo(id);
    }
}

