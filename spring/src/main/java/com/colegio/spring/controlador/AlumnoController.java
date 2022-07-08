package com.colegio.spring.controlador;

import com.colegio.spring.exception.BadRequestException;

import com.colegio.spring.modelo.entidades.Alumno;
import com.colegio.spring.modelo.entidades.Carrera;
import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.servicios.contratos.CarreraDAO;
import com.colegio.spring.modelo.entidades.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController extends PersonaController{

    private final CarreraDAO carreraDao;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDao){
        super(alumnoDao);
        nombreEntidad="Alumno";
        // this.alumnoDao=alumnoDao;
        this.carreraDao = carreraDao;
    }

//    @GetMapping
//    public List<Persona> obtenerTodos(){
//        List<Persona> alumnos =(List<Persona>) alumnoDao.findAll();
//        if(alumnos.isEmpty()){
//            throw new BadRequestException("no existe alumnos");
//        }
//        return alumnos;
//    }
//
//    @GetMapping("/{id}")
//    public Persona obtenerAlumnoPorId(@PathVariable(required = false) Integer id){
//        Optional<Persona> oAlumno=alumnoDao.findByid(id);
//        if(!oAlumno.isPresent()){
//            throw new BadRequestException(String.format("alumno con id %d no existe",id));
//        }
//        return oAlumno.get();
//    }
//
//    @PostMapping
//    public Persona altaAlumno(@RequestBody Persona alumno){
//        return alumnoDao.save(alumno);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Map<String,Object> mensaje=new HashMap<>();
        Persona alumnoUpdate=null;
        Optional<Persona> oAlumno=service.findByid(id);
        if(!oAlumno.isPresent()){
//            throw new BadRequestException(String.format("alumno con id %d no existe",id));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("No se encontro  con id %d no existe", id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        alumnoUpdate=oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());

        mensaje.put("datos",service.save(alumnoUpdate));
        mensaje.put("success",Boolean.TRUE);
        return ResponseEntity.ok(mensaje);

    }
//    @DeleteMapping("/{id}")
//    public void eliminarAlumno(@PathVariable Integer id){
//        alumnoDao.deleteByid(id);
//    }

    @PutMapping("{idAlumno}/carrera/{idCarrera}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer idAlumno,@PathVariable Integer idCarrera){
        Map<String,Object> mensaje=new HashMap<>();
        Optional<Persona> oAlumno=service.findByid(idAlumno);
        if(!oAlumno.isPresent()){
//            throw new BadRequestException(String.format("Alumno con id %d no existe",idAlumno));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("No se encontro  con id %d no existe", idAlumno));
            return ResponseEntity.badRequest().body(mensaje);
        }

        Optional<Carrera> oCarrera=carreraDao.findByid(idCarrera);
        if(!oCarrera.isPresent()){
//            throw new BadRequestException(String.format("Carrera con id %d no existe",idCarrera));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("Carrera con id %d no existe",idCarrera));
            return ResponseEntity.badRequest().body(mensaje);
        }
        Persona alumno=oAlumno.get();
        Carrera carrera=oCarrera.get();
        ((Alumno)alumno).setCarrera(carrera);

        mensaje.put("datos",service.save(alumno));
        mensaje.put("success",Boolean.TRUE);
        return ResponseEntity.ok(mensaje);

    }
}
