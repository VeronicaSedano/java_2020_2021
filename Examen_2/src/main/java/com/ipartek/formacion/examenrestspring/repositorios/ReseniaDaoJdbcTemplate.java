package com.ipartek.formacion.examenrestspring.repositorios;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.examenrestspring.entidades.Resenia;

@Repository
public class ReseniaDaoJdbcTemplate implements ReseniaDao {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Resenia insertar(Resenia resena) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"insert into resenias (descripcion, alumno_codigo, curso_codigo) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, resena.getDescripcion());
			ps.setInt(2, resena.getAlumnoCodigo());
			ps.setInt(3, resena.getCursoCodigo());

			return ps;
		}, keyHolder);

		resena.setId(keyHolder.getKey().longValue());

		return resena;
	}

	@Override
	public Resenia modificar(Resenia resenia) {
		jdbc.update("UPDATE resenias SET descripcion = ?, alumno_codigo = ?, curso_codigo WHERE id = ?",
				resenia.getDescripcion(), resenia.getAlumnoCodigo(), resenia.getCursoCodigo());
		return resenia;
	}

	@Override
	public void borrar(Long id) {
		jdbc.update("DELETE FROM resenias WHERE id = ?", id);

	}

	@Override
	public Iterable<Resenia> obtenerTodos() {
		return jdbc.query("select * from resenas", new BeanPropertyRowMapper<Resenia>(Resenia.class));
	}

	@Override
	public Resenia obtenerPorId(Long id) {
		return jdbc.queryForObject("select * from resenas where id = ?",
				new BeanPropertyRowMapper<Resenia>(Resenia.class), id);
	}

}
