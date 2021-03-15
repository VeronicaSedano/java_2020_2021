package com.reguera.uf2177;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reguera.uf2177.entidades.Libro;
import com.reguera.uf2177.entidades.Resena;
import com.reguera.uf2177.repositorio.LibroDao;

@SpringBootApplication
public class Uf2177Application implements CommandLineRunner {

	@Autowired
	private LibroDao<Libro> dao;

	public static void main(String[] args) {
		SpringApplication.run(Uf2177Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("********************************************************");
		for (Libro l : dao.obtenerTodos()) {
			System.out.println(l);
		}

		System.out.println("********************************************************");

		System.out.println(dao.obtenerPorId(2));

		System.out.println("********************************************************");

		Libro l = dao.obtenerPorIdConColeccion(2);

		System.out.println(l);

		for (Resena r : l.getResenas()) {
			System.out.println(r);
		}

	}

}
