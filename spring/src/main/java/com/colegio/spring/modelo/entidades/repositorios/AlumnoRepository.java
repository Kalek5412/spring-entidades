package com.colegio.spring.modelo.entidades.repositorios;

import com.colegio.spring.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository {
    @Query("select a from Alumno a join fetch a.carrera c where c.nombre =?1")
    Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre);
}
