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

@SpringBootApplication
public class Application {

	@Autowired
	private AlumnoDAO servicio;
	public static void main(String[] args) {
		String[] beanDefinitionNames=SpringApplication.run(Application.class, args).getBeanDefinitionNames();
//		for (String str:beanDefinitionNames) {
//			System.out.println(str);
//		}
	}
	@Bean
	public CommandLineRunner runner(){
		return args->{

			Direccion direccion	=new Direccion("callefalsa","123","51","","","Chimbote");
			Persona alumno=new Alumno(null,"alejandro","lujan","47014701",direccion);

			Persona save=servicio.save(alumno);
			System.out.println(save.toString());
		};
	}

}

