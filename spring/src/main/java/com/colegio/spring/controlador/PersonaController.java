package com.colegio.spring.controlador;

import com.colegio.spring.exception.BadRequestException;
import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.servicios.contratos.PersonaDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonaController extends GenericController<Persona,PersonaDAO>{
    public PersonaController(PersonaDAO service){
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Map<String,Object> mensaje=new HashMap<>();
        Optional<Persona> oPersona=service.buscarPorNombreyApellido(nombre,apellido);
        if(!oPersona.isPresent()){
//            throw new BadRequestException(String.format("No se encontro Persona con nombre %s y apellido %s",nombre,apellido));
        mensaje.put("success",Boolean.FALSE);
        mensaje.put("mensaje",String.format("No se encontro persona con nombre %s y apellidos %s", nombre,apellido));
        return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",oPersona.get());


    return ResponseEntity.ok(mensaje);
}
}
