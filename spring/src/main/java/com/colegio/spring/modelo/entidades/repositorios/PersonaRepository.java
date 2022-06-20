package com.colegio.spring.modelo.entidades.repositorios;

import com.colegio.spring.modelo.entidades.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona,Integer> {

}
