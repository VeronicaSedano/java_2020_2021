package com.ipartek.formacion.examenrestspring.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.examenrestspring.entidades.Curso;

@Repository
public class CursoDaoJdbcTemplate implements Dao<Curso> {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Curso> obtenerTodos() {
		return jdbc.query(
				"select c.codigo, c.nombre, c.identificador, c.nHoras, concat(p.nombre,' ',p.apellidos) from curso c join profesor p on c.profesor_codigo = p.codigo",
				(rs, rowNum) -> new Curso(rs.getLong("c.codigo"), rs.getString("c.nombre"),
						rs.getString("c.identificador"), rs.getInt("c.nHoras"),
						rs.getString("concat(p.nombre,' ',p.apellidos)")));
	}

	@Override
	public Curso obtenerPorId(Long id) {
		return jdbc.queryForObject(
				"select c.codigo, c.nombre, c.identificador, c.nHoras, concat(p.nombre,' ',p.apellidos) profe from curso c join profesor p on c.profesor_codigo = p.codigo where c.codigo = ? order by profe",
				new BeanPropertyRowMapper<Curso>(Curso.class), id);

	}

}
