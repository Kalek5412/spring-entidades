package com.colegio.spring.controlador;

import com.colegio.spring.exception.BadRequestException;
import com.colegio.spring.modelo.entidades.Carrera;
import com.colegio.spring.modelo.entidades.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera,CarreraDAO>{

//  private final CarreraDAO carreraDAO;

    @Autowired
    public CarreraController(CarreraDAO service) {
    super(service);
    nombreEntidad="Carrera";
//  this.carreraDAO = carreraDAO;
    }

//    @GetMapping
//    public List<Carrera> obtenerTodos(){
//        List<Carrera> carreras =(List<Carrera>) carreraDAO.findAll();
//        if(carreras.isEmpty()){
//            throw new BadRequestException("no existe carreras");
//        }
//        return carreras;
//    }

    @GetMapping("/{codigo}")
    public Carrera obtenerPorId(@PathVariable(value="codigo",required = false) Integer id){
        Optional<Carrera> oCarrera=service.findByid(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe",id));
        }
        return oCarrera.get();
    }

    @PostMapping
    public Carrera altaCarrera(@RequestBody Carrera carrera){
        if(carrera.getCantidadAnios()<0){
            throw new BadRequestException("El campo cantidad de años no puede ser negativo");
        }
        if(carrera.getCantidadMaterias()<0){
            throw new BadRequestException("El campo cantidad de materias no puede ser negativo");
        }
        return service.save( carrera);
    }
    @PutMapping("/{id}")
    public Carrera actualizarCarrera(@PathVariable Integer id,@RequestBody Carrera carrera){
        Carrera carreraUpdate=null;
        Optional<Carrera> oCarrera=service.findByid(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe",id));
        }
        carreraUpdate=oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        return service.save(carreraUpdate);
    }
    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        service.deleteByid(id);
    }
}
