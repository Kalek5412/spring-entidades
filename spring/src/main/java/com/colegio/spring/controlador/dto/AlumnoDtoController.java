package com.colegio.spring.controlador.dto;

import com.colegio.spring.modelo.entidades.Alumno;
import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.dto.AlumnoDTO;
import com.colegio.spring.modelo.entidades.dto.PersonaDTO;
import com.colegio.spring.modelo.entidades.mapper.mapstruct.AlumnoMapper;
import com.colegio.spring.modelo.entidades.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class AlumnoDtoController extends PersonaDtoController {


    public AlumnoDtoController(PersonaDAO service, AlumnoMapper alumnoMapper) {
        super(service, "Alumno",alumnoMapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer id){
        Map<String,Object> mensaje= new HashMap<>();
        // Optional<Persona> oPersona=personaDAO.findByid(id);
        //PersonaDTO dto=mapper.mapAlumno((Alumno) oPersona.get());
        mensaje.put("success",Boolean.TRUE);
        //mensaje.put("data",dto);
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaAlumno(@Valid @RequestBody PersonaDTO personaDTO, BindingResult result){
        Map<String,Object> mensaje=new HashMap<>();
        if(result.hasErrors()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("validaciones",super.obtenerValidaciones(result));
            return ResponseEntity.badRequest().body(mensaje);
        }
        PersonaDTO save= super.altaPersona(alumnoMapper.mapAlumno((AlumnoDTO) personaDTO));
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",save);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);

    }
}
