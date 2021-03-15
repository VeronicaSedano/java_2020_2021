package com.reguera.uf2177.repositorio;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.reguera.uf2177.entidades.Resena;

@Repository
public class ReseniaDaoJdbc implements Dao<Resena> {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Resena insertar(Resena r) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO resenas (texto, libros_id) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, r.getTexto());
			ps.setInt(2, r.getLibros_id());
			return ps;
		}, keyHolder);

		r.setId(keyHolder.getKey().intValue());

		return r;
	}

}
