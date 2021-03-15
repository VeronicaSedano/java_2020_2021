package com.ipartek.veronica.uf1466_1.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.veronica.uf1466_1.entidades.Cliente;

public class ClienteDaoMysql implements ClienteDao {

	private static final ClienteDaoMysql INSTANCIA = new ClienteDaoMysql();

	private static final String SQL_SELECT = "SELECT codigo, nombre, email, telefono, poblacion, codigopostal, identificador, activo  FROM cliente";

	private DataSource dataSource = null;

	private ClienteDaoMysql() {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/gestiondocente");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI", e);
		}
	}

	public static ClienteDaoMysql getInstancia() {
		return INSTANCIA;
	}

	@Override
	public Iterable<Cliente> obtenerTodos() {
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Cliente> clientes = new ArrayList<>();
			Cliente cliente;

			while (rs.next()) {
				cliente = new Cliente(rs.getLong("codigo"), rs.getString("nombre"), rs.getString("email"),
						rs.getLong("telefono"), rs.getString("poblacion"), rs.getLong("codigopostal"),
						rs.getString("identificador"), rs.getInt("activo"));

				clientes.add(cliente);
			}

			return clientes;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los registros", e);
		}
	}

	@Override
	public ArrayList<String> cabecera() {
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {

			ResultSetMetaData rsmd = rs.getMetaData();

			ArrayList<String> columnas = new ArrayList<>();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				columnas.add(rsmd.getColumnName(i));
			}

			return columnas;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los registros", e);
		}
	}

}
