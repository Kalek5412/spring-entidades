package com.colegio.spring;

import com.colegio.spring.modelo.entidades.Alumno;
import com.colegio.spring.modelo.entidades.Direccion;
import com.colegio.spring.modelo.entidades.Persona;
import com.colegio.spring.modelo.entidades.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		String[] beanDefinitionNames=SpringApplication.run(Application.class, args).getBeanDefinitionNames();
//		for (String str:beanDefinitionNames) {
//			System.out.println(str);
//		}
	}


}

