package com.ipartek.formacion.supermercado.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.supermercado.modelos.Producto;

public class ProductoDaoMySql implements Dao<Producto> {
	private static final String URL = "jdbc:mysql://localhost:3306/supermercado?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "";

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_IMAGEN = "SELECT url_imagen FROM productos WHERE id = ?";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de JDBC para MySQL", e);
		}
	}

	// SINGLETON

	private ProductoDaoMySql() {
	}

	private final static ProductoDaoMySql INSTANCIA = new ProductoDaoMySql();

	public static ProductoDaoMySql getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Producto> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(SQL_SELECT)) {

			ArrayList<Producto> productos = new ArrayList<>();
			Producto producto;

			while (rs.next()) {
				producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getString("url_imagen"), rs.getBigDecimal("precio"), rs.getInt("descuento"),
						rs.getString("unidad_medida"), rs.getBigDecimal("precio_unidad_medida"), rs.getInt("cantidad"));

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido consultar la lista de productos", e);
		}

	}

	@Override
	public Producto obtenerPorId(Long id) {

		return null;
	}

	@Override
	public void crear(Producto objeto) {

	}

	@Override
	public void modificar(Producto objeto) {

	}

	@Override
	public void eliminar(Long id) {

	}

}
