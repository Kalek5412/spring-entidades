package com.colegio.spring.modelo.entidades.mapper.mapstruct;

import com.colegio.spring.modelo.entidades.Carrera;
import com.colegio.spring.modelo.entidades.dto.CarreraDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CarreraMapperMS {
    @Mappings({
            @Mapping(source = "id",target="codigo"),
            @Mapping(source = "cantidadMaterias",target="cantidad_materias"),
            @Mapping(source = "cantidadAnios",target="cantidad_anios")
    })
    CarreraDTO mapCarrera(Carrera carrera);
}
