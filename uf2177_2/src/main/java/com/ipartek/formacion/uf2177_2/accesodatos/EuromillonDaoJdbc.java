package com.ipartek.formacion.uf2177_2.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.uf2177_2.entidades.Euromillon;

public class EuromillonDaoJdbc implements Dao<Euromillon> {
	private String url, usuario, password;

	private static final EuromillonDaoJdbc INSTANCIA = new EuromillonDaoJdbc();

	private static final String SQL_SELECT = "SELECT id, numeros, estrellas, fecha FROM euromillones";

	private static final String SQL_INSERT = "INSERT INTO euromillones (numeros, estrellas, fecha) VALUES (?, ?, ?)";

	private EuromillonDaoJdbc() {
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

	public static EuromillonDaoJdbc getInstancia() {
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
	public Iterable<Euromillon> obtenerTodos() {
		try (Connection con = getConexion();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Euromillon> euromillones = new ArrayList<>();
			Euromillon euromillon;

			while (rs.next()) {
				euromillon = new Euromillon(rs.getLong("id"), rs.getString("numeros"), rs.getString("estrellas"),
						rs.getString("fecha"));

				euromillones.add(euromillon);
			}

			return euromillones;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los registros de euromillones", e);
		}
	}

	@Override
	public Euromillon agregar(Euromillon euromillon) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, euromillon.getNumeros());
			pst.setString(2, euromillon.getEstrellas());
			pst.setString(3, euromillon.getFecha());

			int num = pst.executeUpdate();

			if (num != 1) {
				throw new AccesoDatosException("Se ha insertado más o menos de un registro ¿?¿?¿?¿?");
			}

			ResultSet rs = pst.getGeneratedKeys();

			if (rs.next()) {
				euromillon.setId(rs.getLong(1));
			} else {
				throw new AccesoDatosException("No se han podido obtener las claves autogeneradas");
			}

			return euromillon;

		} catch (Exception e) {
			throw new AccesoDatosException("Error al agregar el registro a euromillones", e);
		}
	}

}
