package com.example.equipoFutbol.Repository;

import com.example.equipoFutbol.Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    @Query(value = """
    SELECT 
        e.id_equipo,
        e.nombre,
        SUM(
            CASE WHEN p.equipo_local = e.id_equipo THEN p.goles_local ELSE 0 END +
            CASE WHEN p.equipo_visita = e.id_equipo THEN p.goles_visita ELSE 0 END
        ) AS total_goles
    FROM equipo e
    LEFT JOIN partido p ON e.id_equipo = p.equipo_local OR e.id_equipo = p.equipo_visita
    GROUP BY e.id_equipo, e.nombre
    """, nativeQuery = true)
    List<Object[]> obtenerGolesTotalesPorEquipo();


}
