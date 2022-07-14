package com.colegio.spring.modelo.entidades.mapper.mapstruct;
import com.colegio.spring.modelo.entidades.dto.AlumnoDTO;
import com.colegio.spring.modelo.entidades.Alumno;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",config=AlumnoMapperConfig.class)
public abstract class AlumnoMapper {
    public abstract AlumnoDTO mapAlumno(Alumno alumno);
    public abstract Alumno mapAlumno(AlumnoDTO alumnoDTO);
}
