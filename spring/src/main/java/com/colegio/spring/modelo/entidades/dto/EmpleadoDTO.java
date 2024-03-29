package com.colegio.spring.modelo.entidades.dto;

import com.colegio.spring.modelo.entidades.Direccion;
import com.colegio.spring.modelo.entidades.enumeradores.TipoEmpleado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class EmpleadoDTO extends PersonaDTO{
    private BigDecimal sueldo;
    private TipoEmpleado tipoEmpleado;

    public EmpleadoDTO(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }

}
