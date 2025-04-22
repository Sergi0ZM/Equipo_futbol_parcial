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
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jugador;

    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(length = 50, nullable = false)
    private String posicion;
    @Column(length = 50)
    private int dorsal;
    @Column(nullable = false)
    private LocalDate fecha_nac;
    @Column(length = 100, nullable = false)
    private String nacionalidad;
    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;
    @OneToMany(mappedBy = "jugador")
    private List<Estadisticas_jugador> estadisticas;


}
