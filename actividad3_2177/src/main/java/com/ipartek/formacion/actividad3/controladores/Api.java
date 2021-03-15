package com.ipartek.formacion.actividad3.controladores;

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

import com.ipartek.formacion.actividad3.entidades.Libro;
import com.ipartek.formacion.actividad3.entidades.Resena;
import com.ipartek.formacion.actividad3.repositorios.LibroDaoJdbcTemplate;
import com.ipartek.formacion.actividad3.repositorios.ResenaDao;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/libros")
@Log
public class Api {

	@Autowired
	private LibroDaoJdbcTemplate dao1;
	@Autowired
	private ResenaDao dao2;

	@GetMapping
	public Iterable<Libro> get() {
		return dao1.obtenerTodos();
	}

	@GetMapping("{id}")
	public ResponseEntity<Libro> getPorId(@PathVariable Long id) {

		Libro libro = dao1.obtenerPorIdConColeccion(id);

		if (libro == null) {
			log.severe("El id no existe");
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Libro>(libro, HttpStatus.OK);

	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Resena post(@RequestBody Resena resena) {
		log.info(resena.toString());
		return dao2.insertar(resena);
	}

}
