package com.colegio.spring.controlador.dto;


import com.colegio.spring.modelo.entidades.Carrera;
import com.colegio.spring.modelo.entidades.dto.CarreraDTO;
import com.colegio.spring.modelo.entidades.mapper.CarreraMapper;
import com.colegio.spring.modelo.entidades.mapper.mapstruct.CarreraMapperMS;
import com.colegio.spring.modelo.entidades.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class CarreraDtoController extends  GenericDtoController<Carrera,CarreraDAO>{

    @Autowired
    private CarreraMapperMS mapper;


    public CarreraDtoController(CarreraDAO service) {
        super(service, "Carrera");
    }

    @GetMapping
    public ResponseEntity<?> obtenerCarreras(){
        Map<String,Object> mensaje= new HashMap<>();

        List<Carrera> carreras=super.obtenerTodos();
        if(carreras.isEmpty()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("No se enconraron %ss cargadas", nombre_entidad));
            return ResponseEntity.badRequest().body(mensaje);
        }

        List<CarreraDTO> carreraDTOS=carreras.stream().map(mapper::mapCarrera)
                                        .collect(Collectors.toList());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",carreraDTOS);

        return  ResponseEntity.ok(mensaje);


    }
}
