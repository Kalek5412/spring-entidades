package com.colegio.spring.modelo.entidades.mapper;

import com.colegio.spring.modelo.entidades.Carrera;
import com.colegio.spring.modelo.entidades.dto.CarreraDTO;
@Deprecated
public class CarreraMapper {
    public static CarreraDTO mapCarrera(Carrera carrera){
        CarreraDTO dto=new CarreraDTO();
        dto.setCodigo(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setCantidad_anios(carrera.getCantidadAnios());
        dto.setCantidad_materias(carrera.getCantidadMaterias());
        return dto;
    }


}
