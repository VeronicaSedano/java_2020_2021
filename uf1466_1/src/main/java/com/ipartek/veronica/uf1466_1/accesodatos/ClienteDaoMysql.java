package com.ipartek.veronica.uf1466_1.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.veronica.uf1466_1.entidades.Cliente;

public class ClienteDaoMysql implements ClienteDao {

	private String url;
	private String usuario;
	private String password;

	private static final ClienteDaoMysql INSTANCIA = new ClienteDaoMysql();

	private static final String SQL_SELECT = "SELECT codigo, nombre, email, telefono, poblacion, codigopostal, identificador, activo  FROM cliente";

	private ClienteDaoMysql() {
		try {
			Properties props = new Properties();
			props.load(getClass().getClassLoader().getResourceAsStream("jdbc.properties"));

			Class.forName(props.getProperty("jdbc.driver"));

			url = props.getProperty("jdbc.url");
			usuario = props.getProperty("jdbc.usuario");
			password = props.getProperty("jdbc.password");

		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido leer el fichero de configuración jdbc.properties", e);
		}
	}

	public static ClienteDaoMysql getInstancia() {
		return INSTANCIA;
	}

	private Connection getConexion() {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Fallo de conexión", e);
		}
	}

	@Override
	public Iterable<Cliente> obtenerTodos() {
		try (Connection con = getConexion();
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
		try (Connection con = getConexion();
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
