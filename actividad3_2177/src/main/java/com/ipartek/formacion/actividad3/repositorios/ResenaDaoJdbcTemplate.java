package com.ipartek.formacion.actividad3.repositorios;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.actividad3.entidades.Resena;

@Repository
public class ResenaDaoJdbcTemplate implements ResenaDao {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Resena insertar(Resena resena) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement("insert into resenas (texto, libros_id) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, resena.getTexto());
			ps.setInt(2, resena.getLibroId());

			return ps;
		}, keyHolder);

		resena.setId(keyHolder.getKey().longValue());

		return resena;
	}

	@Override
	public Iterable<Resena> obtenerTodos() {
		return jdbc.query("select * from resenas", new BeanPropertyRowMapper<Resena>(Resena.class));
	}

	@Override
	public Resena obtenerPorId(Long id) {
		return jdbc.queryForObject("select * from resenas where id = ?",
				new BeanPropertyRowMapper<Resena>(Resena.class), id);
	}

}
