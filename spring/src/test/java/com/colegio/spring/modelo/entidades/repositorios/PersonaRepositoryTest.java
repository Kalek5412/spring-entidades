package com.colegio.spring.modelo.entidades.repositorios;

import com.colegio.spring.datos.DatosDummy;
import com.colegio.spring.modelo.entidades.Empleado;
import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.colegio.spring.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;
    @Autowired
    @Qualifier("empleadoRepository")
    PersonaRepository empleadoRepository;
    @Autowired
    @Qualifier("profesorRepository")
    PersonaRepository profesorRepository;

    @Test
    void buscarPorNombreyApellido() {
        //gvn
        Persona save=empleadoRepository.save(DatosDummy.empleado01());
        //when
        Optional<Persona> expected=empleadoRepository.buscarPorNombreyApellido(DatosDummy.empleado01().getNombre(),DatosDummy.empleado01().getApellido());
        //then
        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(save);
    }

    @Test
    void buscarPorDni() {
        Persona save = profesorRepository.save(profesor01());

        Optional<Persona> expected=profesorRepository.buscarPorDni(profesor01().getDni());

        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(save);
        assertThat(expected.get().getDni()).isEqualTo(save.getDni());

    }

    @Test
    void buscarPersonaporApellido() {
        Iterable<Persona> personas= alumnoRepository.saveAll(
                Arrays.asList(
                        alumno01(),
                        alumno02(),
                        alumno03()
                )
        );
        String apel="benito";
        List<Persona> expected=(List<Persona>)alumnoRepository.buscarPersonaporApellido(apel);

        assertThat(expected.size()==2).isTrue();
    }
}