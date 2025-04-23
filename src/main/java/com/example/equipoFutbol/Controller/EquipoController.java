package com.example.equipoFutbol.Controller;

import com.example.equipoFutbol.Model.Equipo;
import com.example.equipoFutbol.Service.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @GetMapping("/goles-totales")
    public ResponseEntity<List<Map<String, Object>>> obtenerGolesTotalesPorEquipo() {
        try {
            List<Object[]> resultados = equipoService.obtenerGolesTotalesPorEquipo();
            List<Map<String, Object>> respuesta = new ArrayList<>();

            for (Object[] fila : resultados) {
                Map<String, Object> mapa = new HashMap<>();
                mapa.put("id_equipo", fila[0]);
                mapa.put("nombre", fila[1]);
                mapa.put("total_goles", fila[2]);
                respuesta.add(mapa);
            }

            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

