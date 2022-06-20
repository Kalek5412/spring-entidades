package com.colegio.spring.modelo.entidades.servicios.implementaciones;


import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.repositorios.PersonaRepository;
import com.colegio.spring.modelo.entidades.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class AlumnoDAOImpl implements AlumnoDAO {

    @Autowired
    @Qualifier("repositorioAlumnos")
    private PersonaRepository repository;


    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findByid(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return repository.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteByid(Integer id) {
        repository.deleteById(id);
    }
}

