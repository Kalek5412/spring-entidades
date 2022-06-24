package com.colegio.spring.modelo.entidades.servicios.contratos;

import com.colegio.spring.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona> {

    Optional<Persona> buscarPorNombreyApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDni(String dni);
    Iterable<Persona> buscarPersonaporApellido(String apellido);
}
