package com.colegio.spring.modelo.entidades.servicios.implementaciones;

import com.colegio.spring.modelo.entidades.repositorios.AlumnoRepository;
import com.colegio.spring.modelo.entidades.servicios.contratos.PersonaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonaDAOImplTest {

    PersonaDAO personaDAO;
    @Mock
    AlumnoRepository alumnoRepository;

    @BeforeEach
    void setUp(){
        personaDAO = new PersonaDAOImpl(alumnoRepository);
    }

    @Test
    void buscarPorNombreyApellido() {
        personaDAO.buscarPorNombreyApellido(anyString(),anyString());

        verify(alumnoRepository).buscarPorNombreyApellido(anyString(),anyString());
    }

    @Test
    void buscarPorDni() {
        personaDAO.buscarPorDni(anyString());

        verify(alumnoRepository).buscarPorDni(anyString());
    }

    @Test
    void buscarPersonaporApellido() {
        personaDAO.buscarPersonaporApellido(anyString());

        verify(alumnoRepository).buscarPersonaporApellido(anyString());
    }


}