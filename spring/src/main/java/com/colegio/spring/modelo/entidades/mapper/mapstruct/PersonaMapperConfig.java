package com.colegio.spring.modelo.entidades.mapper.mapstruct;

import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.dto.PersonaDTO;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface PersonaMapperConfig {
    void mapPersona(Persona persona, @MappingTarget PersonaDTO personaDTO);
}
