package com.colegio.spring.modelo.entidades.repositorios;

import com.colegio.spring.modelo.entidades.Alumno;
import com.colegio.spring.modelo.entidades.Carrera;
import com.colegio.spring.modelo.entidades.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static com.colegio.spring.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class AlumnoRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;
    @Autowired
    CarreraRepository carreraRepository;
    @Test
    void buscarAlumnoPorNombreCarrera() {
        Iterable<Persona> personas=alumnoRepository.saveAll(
                Arrays.asList(
                        alumno01(),
                        alumno02(),
                        alumno03()
                )
        );
        Carrera save = carreraRepository.save(carrera01(false));
        personas.forEach(alumno->((Alumno)alumno).setCarrera(save));
        alumnoRepository.saveAll(personas);

        String carreraNombre="Ingenieria en Sistemas";
        List<Persona> expected=(List<Persona>)((AlumnoRepository)alumnoRepository).buscarAlumnoPorNombreCarrera(carreraNombre);

        assertThat(expected.size()==3).isTrue();
    }
    @Test
    void buscarAlumnoPorNombreCarrerasinValores() {
        Iterable<Persona> personas=alumnoRepository.saveAll(
                Arrays.asList(
                        alumno01(),
                        alumno02(),
                        alumno03()
                )
        );
        Carrera save = carreraRepository.save(carrera01(false));
        personas.forEach(alumno->((Alumno)alumno).setCarrera(save));
        alumnoRepository.saveAll(personas);

        String carreraNombre="Ingenieria en Alimentos";
        List<Persona> expected=(List<Persona>)((AlumnoRepository)alumnoRepository).buscarAlumnoPorNombreCarrera(carreraNombre);

        assertThat(expected.isEmpty()).isTrue();
    }
}