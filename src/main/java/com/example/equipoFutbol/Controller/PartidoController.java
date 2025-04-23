package com.example.equipoFutbol.Controller;

import com.example.equipoFutbol.Model.Partido;
import com.example.equipoFutbol.Service.PartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }
    @PostMapping
    public Partido guardarPartido(@RequestBody Partido partido) {
        return partidoService.guardarPartido(partido);
    }

    @GetMapping
    public List<Partido> listarPartidos() {
        return partidoService.listarPartidos();
    }

    @GetMapping("/{id}")
    public Optional<Partido> obtenerPartidoPorId(@PathVariable int id) {
        return partidoService.listarPartidoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPartido(@PathVariable int id) {
        partidoService.eliminarPartido(id);
    }
    @GetMapping("/resultados")
    public ResponseEntity<List<Map<String, Object>>> obtenerResultadosPartidos() {
        try {
            List<Object[]> resultados = partidoService.obtenerResultadosConNombresEquipos();
            List<Map<String, Object>> respuesta = new ArrayList<>();

            for (Object[] fila : resultados) {
                Map<String, Object> mapa = new HashMap<>();
                mapa.put("id_partido", fila[0]);
                mapa.put("fecha", fila[1]);
                mapa.put("estadio", fila[2]);
                mapa.put("equipo_local", fila[3]);
                mapa.put("equipo_visita", fila[4]);
                mapa.put("goles_local", fila[5]);
                mapa.put("goles_visita", fila[6]);
                respuesta.add(mapa);
            }

            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
