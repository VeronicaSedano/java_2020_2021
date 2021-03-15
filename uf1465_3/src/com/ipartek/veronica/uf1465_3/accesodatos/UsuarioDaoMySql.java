package com.ipartek.veronica.uf1465_3.accesodatos;

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

import com.ipartek.veronica.uf1465_3.entidades.Usuario;

public class UsuarioDaoMySql implements UsuarioDao {

	private static final String SQL_SEL = "SELECT id, nombre, password FROM usuarios";
	private static final String SQL_SELECT = SQL_SEL + " ORDER BY id";
	private static final String SQL_SELECT_NOMBRE = SQL_SEL + " WHERE nombre = ?";

	private DataSource dataSource = null;

	public UsuarioDaoMySql() {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/uf1465_3");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI", e);
		}
	}

	@Override
	public Iterable<Usuario> obtenerTodos() {
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Usuario> usuarios = new ArrayList<>();
			Usuario usuario;

			while (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("password"));

				usuarios.add(usuario);
			}

			return usuarios;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros de usuarios", e);
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se han podido obtener todos los registros de usuarios", e);
		}
	}

	@Override
	public Usuario obtenerPorNombre(String nombre) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_NOMBRE);) {

			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();

			Usuario usuario = null;

			if (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("password"));
			}

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el usuario cuyo email es: " + nombre, e);
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se ha podido obtener el usuario cuyo email es: " + nombre, e);
		}
	}

}
