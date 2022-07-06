package com.colegio.spring.controlador;

import com.colegio.spring.exception.BadRequestException;
import com.colegio.spring.modelo.entidades.servicios.contratos.GenericoDAO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class GenericController <E,S extends GenericoDAO<E>> {
    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service){
        this.service=service;
    }

    @GetMapping
    public List<E> obtenerTodos(){
        List<E> listado=(List<E>) service.findAll();
        if (listado.isEmpty()){
            throw new BadRequestException(String.format("No se ha encontado %ss",nombreEntidad));
        }
        return listado;
    }


}
