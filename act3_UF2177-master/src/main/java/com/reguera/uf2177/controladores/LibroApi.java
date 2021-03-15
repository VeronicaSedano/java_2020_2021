package com.reguera.uf2177.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reguera.uf2177.entidades.Libro;
import com.reguera.uf2177.entidades.Resena;
import com.reguera.uf2177.repositorio.LibroDao;
import com.reguera.uf2177.repositorio.ReseniaDaoJdbc;

import lombok.extern.java.Log;

@RestController
@Log
@RequestMapping("/api/libros")
public class LibroApi {

	@Autowired
	private LibroDao<Libro> dao;

	@Autowired
	private ReseniaDaoJdbc dao2;

	@GetMapping
	public Iterable<Libro> get() {
		return dao.obtenerTodos();
	}

	@GetMapping("{id}")
	public ResponseEntity<Libro> getPorIdConResenias(@PathVariable int id) {

		Libro libro = dao.obtenerPorIdConColeccion(id);

		if (libro == null) {

			log.severe("El id del libro no existe");
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Libro>(libro, HttpStatus.OK);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Resena post(@RequestBody Resena resena) {

		log.info("Se ha creado nueva reseña: " + resena.toString());
		return dao2.insertar(resena);
	}

}
