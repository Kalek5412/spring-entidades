package com.colegio.spring.modelo.entidades.servicios.contratos;


import com.colegio.spring.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{
    Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre);

}
