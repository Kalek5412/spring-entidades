package com.colegio.spring.modelo.entidades.servicios.implementaciones;

import com.colegio.spring.modelo.entidades.servicios.contratos.GenericoDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericoDAOImpl <E,R extends CrudRepository<E,Integer>> implements GenericoDAO<E> {

    protected final R repository;

    public GenericoDAOImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findByid(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entidad) {
        return repository.save(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteByid(Integer id) {
        repository.deleteById(id);
    }
}
