package com.colegio.spring.modelo.entidades.servicios.implementaciones;

import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.repositorios.AlumnoRepository;
import com.colegio.spring.modelo.entidades.servicios.contratos.AlumnoDAO;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class AlumnoDAOImplTest {
    
    @MockBean
    AlumnoRepository alumnoRepository;
    @Autowired
    AlumnoDAO alumnoDAO;
    
    @Test
    void buscarAlumnoPorNombreCarrera() {
        alumnoDAO.buscarAlumnoPorNombreCarrera(anyString());

        verify(alumnoRepository).buscarAlumnoPorNombreCarrera(anyString());
    }


}