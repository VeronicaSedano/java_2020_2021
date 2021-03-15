package com.ipartek.veronica.uf1466_2.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.veronica.uf1466_2.entidades.Autor;
import com.ipartek.veronica.uf1466_2.entidades.Libro;

public class LibroDaoMysql implements LibroDao {

	private static final String SQL_SELECT = "SELECT l.id l_id, l.titulo l_titulo, l.ISBN l_ISBN, a.id a_id, a.nombre a_nombre, a.apellidos a_apellidos FROM libros AS l\r\n"
			+ "LEFT JOIN autores AS a ON l.autores_id = a.id ";

	private static final String SQL_SELECT_ID = SQL_SELECT + "WHERE l.id = ?";

	private static final String SQL_SELECT_ISBN = SQL_SELECT + "WHERE l.ISBN = ?";

	private DataSource dataSource = null;

	public LibroDaoMysql() {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/uf1466_2");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de uf1466_2", e);
		}
	}

	/**
	 * Metodo para obtener todos los libros que hay en la base de datos
	 */
	@Override
	public Iterable<Libro> obtenerTodos() {
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {

			ArrayList<Libro> libros = new ArrayList<>();
			Autor autor;
			Libro libro;

			while (rs.next()) {
				autor = new Autor(rs.getLong("a_id"), rs.getString("a_nombre"), rs.getString("a_apellidos"));
				libro = new Libro(rs.getLong("l_id"), rs.getString("l_titulo"), rs.getString("l_ISBN"), autor);
				libros.add(libro);
			}

			return libros;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros de libros");
		} catch (Exception e) {
			throw new AccesoDatosException("ERROR: No se han podido obtener todos los registros de libros");
		}
	}

	/**
	 * Metodo para buscar por id un libro
	 */
	@Override
	public Libro obtenerPorId(Long id) {
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				Libro libro = null;
				Autor autor;

				if (rs.next()) {
					libro = new Libro(rs.getLong("l_id"), rs.getString("l_titulo"), rs.getString("l_ISBN"), null);
					autor = new Autor(rs.getLong("a_id"), rs.getString("a_nombre"), rs.getString("a_apellidos"));
					libro.setAutor(autor);
				}

				return libro;
			}
		} catch (Exception e) {
			throw new AccesoDatosException("ERROR: No se ha podido obtener el registro de libro", e);
		}
	}

	/**
	 * Metodo para buscar un libro por su ISBN
	 * 
	 */
	@Override
	public Libro buscarPorIsbn(String ISBN) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_ISBN);) {

			ps.setString(1, ISBN);

			try (ResultSet rs = ps.executeQuery()) {
				Libro libro = null;
				Autor autor = null;

				if (rs.next()) {
					libro = new Libro(rs.getLong("l_id"), rs.getString("l_titulo"), rs.getString("l_ISBN"), null);
					autor = new Autor(rs.getLong("a_id"), rs.getString("a_nombre"), rs.getString("a_apellidos"));
					libro.setAutor(autor);
				}

				return libro;
			}
		} catch (Exception e) {
			throw new AccesoDatosException("ERROR: No se ha podido obtener el registro de libro", e);
		}
	}

}
