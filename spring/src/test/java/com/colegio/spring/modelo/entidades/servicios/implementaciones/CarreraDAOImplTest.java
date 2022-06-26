package com.colegio.spring.modelo.entidades.servicios.implementaciones;


import com.colegio.spring.modelo.entidades.Carrera;
import com.colegio.spring.modelo.entidades.repositorios.CarreraRepository;
import com.colegio.spring.modelo.entidades.servicios.contratos.CarreraDAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Arrays;
import java.util.List;

import static com.colegio.spring.datos.DatosDummy.carrera03;
import static com.colegio.spring.datos.DatosDummy.carrera01;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarreraDAOImplTest {
    CarreraDAO carreraDAO;
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp(){
        carreraRepository=mock(CarreraRepository.class);
        carreraDAO=new CarreraDAOImpl(carreraRepository);
    }


    @Test
    void findCarrerasByNombreContains() {
        String nombre="Ingenieria";
        when(carreraRepository.findCarrerasByNombreContains(nombre))
                .thenReturn(Arrays.asList(carrera01(true),carrera03(true)));

        List<Carrera> expected=(List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarrerasByNombreContains(nombre);
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
        String nombre="ingenieria";
        when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre))
                .thenReturn(Arrays.asList(carrera01(true),carrera03(true)));

        List<Carrera> expected=(List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Test
    void findCarrerasByCantidadAniosAfter() {
        int cantidad=4;
        when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad))
                .thenReturn(Arrays.asList(carrera01(true),carrera03(true)));

        List<Carrera> expected=(List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);

        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);
    }
    
}