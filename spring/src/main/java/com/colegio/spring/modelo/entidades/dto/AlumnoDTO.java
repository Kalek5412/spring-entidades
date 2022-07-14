package com.colegio.spring.modelo.entidades.dto;

import com.colegio.spring.modelo.entidades.Direccion;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
public class AlumnoDTO extends PersonaDTO {
    public AlumnoDTO(Integer id, String nombre, String apellido,  String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }


}
