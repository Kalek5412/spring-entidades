package com.colegio.spring.datos;

import com.colegio.spring.modelo.entidades.*;
import com.colegio.spring.modelo.entidades.enumeradores.TipoEmpleado;

import java.math.BigDecimal;

public class DatosDummy {

    public static Carrera carrera01(boolean conId) {
        Carrera carrera= (conId) ? new Carrera(1,"Ingenieria en Sistemas",50,5) :
            new Carrera(null,"Ingenieria en Sistemas",50,5);
        return carrera;

    }
    public static Carrera carrera02(){
        return new Carrera(null,"Licenciatura en Sistemas",45,4);
    }
    public static Carrera carrera03(boolean conId){
        Carrera carrera=(conId) ? new Carrera(3,"Ingenieria Industrial",60,5):
            new Carrera(null,"Ingenieria Industrial",60,5);
        return carrera;
    }

    public static Persona empleado01(){
        return  new Empleado(null,"luis","lujan","54658987",new Direccion(),new BigDecimal("51525.77"), TipoEmpleado.ADMINISTRATIVO);
    }
    public static Persona empleado02(){
        return  new Empleado(null,"miguel","llauri","54658988",new Direccion(),new BigDecimal("51425.77"), TipoEmpleado.MANTENIMIENTO);
    }
    public static Persona profesor01(){
        return  new Profesor(null,"jose","lopez","12658988",new Direccion(),new BigDecimal("51425.77"));
    }
    public static Persona alumno01(){
        return  new Alumno(null,"jhon","metal","12128988",new Direccion());}
    public static Persona alumno02(){
        return  new Alumno(null,"fashion","benito","12121188",new Direccion());}
    public static Persona alumno03(){
        return  new Alumno(null,"andy","benito","12128911",new Direccion());}


}
