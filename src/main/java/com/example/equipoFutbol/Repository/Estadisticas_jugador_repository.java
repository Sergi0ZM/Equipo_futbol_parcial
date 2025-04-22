package com.example.equipoFutbol.Repository;

import com.example.equipoFutbol.Model.Estadisticas_jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Estadisticas_jugador_repository extends JpaRepository<Estadisticas_jugador, Integer> {
}
