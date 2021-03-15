package com.ipartek.formacion.examenrestspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.examenrestspring.entidades.Curso;
import com.ipartek.formacion.examenrestspring.entidades.Resenia;
import com.ipartek.formacion.examenrestspring.repositorios.CursoDaoJdbcTemplate;
import com.ipartek.formacion.examenrestspring.repositorios.Dao;
import com.ipartek.formacion.examenrestspring.repositorios.ReseniaDao;

@RestController
@RequestMapping("/api/cursos")
public class Api {
	@Autowired
	private Dao<Curso> dao;

	@Autowired
	private CursoDaoJdbcTemplate dao1;
	@Autowired
	private ReseniaDao dao2;

	@GetMapping
	public Iterable<Curso> get() {
		return dao.obtenerTodos();
	}

	@GetMapping("{id}")
	public ResponseEntity<Curso> getPorId(@PathVariable Long id) {
		Curso curso = dao1.obtenerPorId(id);

		if (curso == null) {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Resenia post(@RequestBody Resenia resenia) {
		return dao2.insertar(resenia);
	}

	@PutMapping("{id}")
	public ResponseEntity<Resenia> put(@PathVariable Long id, @RequestBody Resenia resenia) {
		if (id != resenia.getId()) {
			return new ResponseEntity<Resenia>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Resenia>(dao2.modificar(resenia), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Resenia> delete(@PathVariable Long id) {
		try {
			dao2.borrar(id);
			return new ResponseEntity<Resenia>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Resenia>(HttpStatus.NOT_FOUND);
		}
	}
}
