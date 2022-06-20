package com.colegio.spring.modelo.entidades.servicios.contratos;

import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.Carrera;

import java.util.Optional;

public interface AlumnoDAO {
    Optional<Persona> findByid(Integer id);
    Persona save(Persona persona);
    Iterable<Persona> findAll();
    void deleteByid(Integer id);
}
