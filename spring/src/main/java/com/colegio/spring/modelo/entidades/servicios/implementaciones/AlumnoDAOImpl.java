package com.colegio.spring.modelo.entidades.servicios.implementaciones;


import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.repositorios.AlumnoRepository;
import com.colegio.spring.modelo.entidades.repositorios.PersonaRepository;
import com.colegio.spring.modelo.entidades.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos")PersonaRepository repository) {
        super(repository);
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre){
        return ((AlumnoRepository)repository).buscarAlumnoPorNombreCarrera(nombre);
    }

}

