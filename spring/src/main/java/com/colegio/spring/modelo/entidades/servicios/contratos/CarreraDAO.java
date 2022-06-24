package com.colegio.spring.modelo.entidades.servicios.contratos;

import com.colegio.spring.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO extends GenericoDAO<Carrera>{

    Iterable<Carrera>findCarrerasByNombreContains(String nombre);

    Iterable<Carrera>findCarrerasByNombreContainsIgnoreCase(String nombre);

    Iterable<Carrera>findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
}
