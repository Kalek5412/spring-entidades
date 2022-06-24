package com.colegio.spring;

import com.colegio.spring.modelo.entidades.Alumno;
import com.colegio.spring.modelo.entidades.Carrera;
import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.servicios.contratos.AlumnoDAO;
import com.colegio.spring.modelo.entidades.servicios.contratos.CarreraDAO;
import com.colegio.spring.modelo.entidades.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnosComando implements CommandLineRunner {
    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;
    @Autowired
    private CarreraDAO carreraDAO;

    @Override
    public void run(String... args) throws Exception {
//        Optional<Carrera>ingSistemas=carreraDAO.findByid(7);
//
//        Iterable<Persona> alumnos=personaDAO.findAll();
//        alumnos.forEach(alumno ->((Alumno)alumno).setCarrera(ingSistemas.get()));
//        alumnos.forEach(alumno->personaDAO.save(alumno));

//        Optional<Persona> alumno_1 = personaDAO.findByid(2);


//        Optional<Persona>personaNomApe=personaDAO.buscarPorNombreyApellido(alumno_1.get().getNombre(),alumno_1.get().getApellido());
//        System.out.println(personaNomApe.toString());
//
//        Optional<Persona> personaDni=personaDAO.buscarPorDni(alumno_1.get().getDni());
//        System.out.println(personaDni.toString());
//
//        Iterable<Persona>personasApellido=personaDAO.buscarPersonaporApellido(alumno_1.get().getApellido());
//        personasApellido.forEach(System.out::println);

        Optional<Carrera>ingSistemas=carreraDAO.findByid(7);
        Iterable<Persona>alumnosCarrera=((AlumnoDAO)personaDAO).buscarAlumnoPorNombreCarrera(ingSistemas.get().getNombre());
        alumnosCarrera.forEach(System.out::println);
    }
}
