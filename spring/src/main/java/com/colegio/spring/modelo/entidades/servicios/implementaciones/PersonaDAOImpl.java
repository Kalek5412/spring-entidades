package com.colegio.spring.modelo.entidades.servicios.implementaciones;

import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.repositorios.PersonaRepository;
import com.colegio.spring.modelo.entidades.servicios.contratos.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO {

    public PersonaDAOImpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreyApellido(String nombre, String apellido) {
        return repository.buscarPorNombreyApellido(nombre,apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDni(String dni) {
        return repository.buscarPorDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonaporApellido(String apellido) {
        return repository.buscarPersonaporApellido(apellido);
    }
}
