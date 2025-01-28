package com.angular_springb_sql.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EntityScan(basePackages = "entity") // Reemplaza con tu paquete real
@EntityScan(basePackages = "com.angular_springb_sql.crud") // Cambia a tu ruta real de entidad
//@ComponentScan(basePackages = "com.angular_springb_sql.crud")    // Asegúrate de que Spring encuentre los controladores, servicios y repositorios

public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
