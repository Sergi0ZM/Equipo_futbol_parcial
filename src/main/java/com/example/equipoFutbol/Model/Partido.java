package com.example.equipoFutbol.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_partido;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 100, nullable = false)
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "equipo_local", referencedColumnName = "id_equipo")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita", referencedColumnName = "id_equipo")
    private Equipo equipoVisita;

    private int goles_local;
    private int goles_visita;
    @OneToMany(mappedBy = "partido")
    private List<Estadisticas_jugador> estadisticas;

}
