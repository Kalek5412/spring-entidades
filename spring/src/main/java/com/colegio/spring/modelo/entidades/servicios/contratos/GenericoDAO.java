package com.colegio.spring.modelo.entidades.servicios.contratos;

import com.colegio.spring.modelo.entidades.Carrera;

import java.util.Optional;

public interface GenericoDAO<E> {
    Optional<E> findByid(Integer id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteByid(Integer id);
}
