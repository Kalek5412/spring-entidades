package com.colegio.spring.controlador.dto;

import com.colegio.spring.modelo.entidades.Alumno;
import com.colegio.spring.modelo.entidades.Empleado;
import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.Profesor;
import com.colegio.spring.modelo.entidades.dto.PersonaDTO;
import com.colegio.spring.modelo.entidades.mapper.mapstruct.AlumnoMapper;
import com.colegio.spring.modelo.entidades.servicios.contratos.PersonaDAO;

public class PersonaDtoController extends GenericDtoController<Persona, PersonaDAO>{
    protected final AlumnoMapper alumnoMapper;


    public PersonaDtoController(PersonaDAO service, String nombre_entidad, AlumnoMapper alumnoMapper) {
        super(service, nombre_entidad);
        this.alumnoMapper = alumnoMapper;
    }

    public PersonaDTO altaPersona(Persona persona){
        Persona personaEntidad=super.altaEntidad(persona);
        PersonaDTO dto=null;
        if(personaEntidad instanceof Alumno){
            dto=alumnoMapper.mapAlumno((Alumno) personaEntidad);
        }else if(personaEntidad instanceof Profesor){
            //maper profesor
        }else if (personaEntidad instanceof Empleado){
            //mapper empeleado
        }
        return dto;
    }
}
