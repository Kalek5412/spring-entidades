package com.colegio.spring.modelo.entidades.servicios.implementaciones;

import com.colegio.spring.modelo.entidades.Carrera;
import com.colegio.spring.modelo.entidades.repositorios.CarreraRepository;
import com.colegio.spring.modelo.entidades.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CarreraDAOImpl implements CarreraDAO {

    @Autowired
    private CarreraRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Carrera> findByid(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Carrera save(Carrera carrera) {
        return repository.save(carrera);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteByid(Integer id) {
        repository.deleteById(id);
    }
}
