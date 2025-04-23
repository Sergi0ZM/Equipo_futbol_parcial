package com.example.equipoFutbol.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estadisticas_jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estadistica;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido partido ;

    private int minutos_jugados;
    private int goles;
    private int asistencias;
    private int tarjetas_amarillas;
    private int tarjetas_rojas;


}
