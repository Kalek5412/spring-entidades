package com.colegio.spring.modelo.entidades.servicios.contratos;

import com.colegio.spring.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO {
    Optional<Carrera> findByid(Integer id);
    Carrera save(Carrera carrera);
    Iterable<Carrera> findAll();
    void deleteByid(Integer id);
}
