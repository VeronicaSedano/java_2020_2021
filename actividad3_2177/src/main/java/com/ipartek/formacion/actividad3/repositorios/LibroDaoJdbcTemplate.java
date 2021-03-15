package com.ipartek.formacion.actividad3.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.actividad3.entidades.Libro;
import com.ipartek.formacion.actividad3.entidades.Resena;

@Repository
public class LibroDaoJdbcTemplate implements Dao<Libro> {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Libro> obtenerTodos() {
		return jdbc.query("select l.id, l.nombre, a.nombre from libros l join autores a on l.autores_id = a.id",
				(rs, rowNum) -> new Libro(rs.getLong("l.id"), rs.getString("l.nombre"), rs.getString("a.nombre")));
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return jdbc.queryForObject(
				"select l.id, l.nombre, a.nombre from libros l join autores a on l.autores_id = a.id where l.id = ? order by a.nombre",
				new BeanPropertyRowMapper<Libro>(Libro.class), id);
	}

	public Libro obtenerPorIdConColeccion(Long id) {
		Libro libro = obtenerPorId(id);
		List<Resena> resenas = jdbc.query(
				"select r.id, r.texto, r.libros_id from resenas r join libros l on r.libros_id = l.id  where l.id =?",
				(rs, rowNum) -> new Resena(rs.getLong("r.id"), rs.getString("r.texto"), rs.getInt("r.libros_id")), id);
		libro.getResenas().addAll(resenas);
		return libro;

	}

}
