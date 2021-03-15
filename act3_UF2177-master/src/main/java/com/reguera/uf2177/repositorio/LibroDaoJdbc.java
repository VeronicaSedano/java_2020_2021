package com.reguera.uf2177.repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.reguera.uf2177.entidades.Libro;
import com.reguera.uf2177.entidades.Resena;

@Repository
public class LibroDaoJdbc implements LibroDao<Libro> {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Libro> obtenerTodos() {
		return jdbc.query(
				"SELECT l.id, l.nombre, concat(a.nombre,' ',a.apellidos) \r\n" + "FROM libros l\r\n"
						+ "JOIN autores a ON l.autores_id = a.id \r\n",
				(rs, rowNum) -> new Libro(rs.getInt("l.id"), rs.getString("l.nombre"),
						rs.getString("CONCAT(a.nombre,' ',a.apellidos)")));
	}

	@Override
	public Libro obtenerPorId(int id) {

		return jdbc.queryForObject(
				"SELECT l.id, l.nombre, concat(a.nombre,' ',a.apellidos) autor \r\n" + "FROM libros l\r\n"
						+ "JOIN autores a ON l.autores_id = a.id  \r\n" + "WHERE l.id = ?\r\n" + "ORDER BY autor",
				new BeanPropertyRowMapper<Libro>(Libro.class), id);
	}

	@Override
	public Libro obtenerPorIdConColeccion(int id) {

		Libro libro = obtenerPorId(id);
		List<Resena> resenas = jdbc.query(
				"SELECT r.id, r.texto, r.libros_id FROM resenas r JOIN libros l ON r.libros_id = l.id  WHERE l.id =?",
				(rs, rowNum) -> new Resena(rs.getInt("r.id"), rs.getString("r.texto"), rs.getInt("r.libros_id")), id);
		libro.getResenas().addAll(resenas);
		return libro;
	}

}
