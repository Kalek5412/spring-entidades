package com.colegio.spring;

import com.colegio.spring.modelo.entidades.Carrera;
import com.colegio.spring.modelo.entidades.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Component
public class CarreraComandos implements CommandLineRunner {
    @Autowired
    private CarreraDAO servicio;

    @Override
    public void run(String... args) throws Exception {

////        Carrera ingIndustrial = new Carrera(null,"ingenieria Industrial",55,5);
//       Carrera ingSistemas = new Carrera(null,"ingenieria Sistemas",54,5);
////        Carrera ingAlimentos = new Carrera(null,"ingenieria Alimentos",54,5);
////        Carrera ingAmbiental = new Carrera(null,"ingenieria Ambiental",56,6);
////        Carrera ingElectronica = new Carrera(null,"ingenieria Electronica",52,5);
////
////        servicio.save(ingAlimentos);
//       servicio.save(ingSistemas);
////        servicio.save(ingIndustrial);
////        servicio.save(ingAmbiental);
////        servicio.save(ingElectronica);


//       List<Carrera> carreras=(List<Carrera>)servicio.findCarrerasByNombreContains("Sistemas");
//        carreras.forEach(System.out::println);
//
//        List<Carrera> carrerasIgnoreCase1=(List<Carrera>)servicio.findCarrerasByNombreContainsIgnoreCase("SISTEMAS");
//        List<Carrera> carrerasIgnoreCase2=(List<Carrera>)servicio.findCarrerasByNombreContainsIgnoreCase("sistemas");
//        carrerasIgnoreCase1.forEach(System.out::println);
//        carrerasIgnoreCase2.forEach(System.out::println);

//        List<Carrera> carrerasPorAnio=(List<Carrera>)servicio.findCarrerasByCantidadAniosAfter(4);
//        carrerasPorAnio.forEach(System.out::println);
    }
}
