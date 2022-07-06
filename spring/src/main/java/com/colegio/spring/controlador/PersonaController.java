package com.colegio.spring.controlador;

import com.colegio.spring.exception.BadRequestException;
import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.servicios.contratos.PersonaDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class PersonaController extends GenericController<Persona,PersonaDAO>{
    public PersonaController(PersonaDAO service){
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public Persona buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Optional<Persona> oPersona=service.buscarPorNombreyApellido(nombre,apellido);
        if(!oPersona.isPresent()){
            throw new BadRequestException(String.format("No se encontro Persona con nombre %s y apellido %s",nombre,apellido));
        }

    return oPersona.get();
}
}
