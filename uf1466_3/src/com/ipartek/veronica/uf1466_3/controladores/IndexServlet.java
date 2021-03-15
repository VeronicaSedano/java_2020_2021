package com.ipartek.veronica.uf1466_3.controladores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.veronica.uf1466_3.accesodatos.AccesoDatosException;

@WebServlet("/index")
@MultipartConfig
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = -5472203944254827222L;

	private static final String URL = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "";

	private static final String SQL_DROP = "drop database if exists gestiondocentecopia";
	private static final String SQL_CREATE = "create database gestiondocentecopia";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Hacer backup (de la BDD a un fichero)
		Process p = Runtime.getRuntime().exec("mysqldump -u root gestiondocente");

		// El archivo gestiondocentecopia.sql se guarda por defecto en el escritorio
		try (InputStream is = p.getInputStream();
				FileOutputStream fos = new FileOutputStream("gestiondocentecopia.sql")) {
			byte[] buffer = new byte[1000];

			int leido;
			while ((leido = is.read(buffer)) > 0) {
				fos.write(buffer, 0, leido);
			}
		}

		try {
			int processComplete = p.waitFor();

			if (processComplete == 0) {
				System.out.println("Todo correcto (backup)");
			} else {
				System.out.println("Ha habido algún error (backup)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Conexion a la BBDD
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de JDBC para Mysql", e);
		}

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_DROP)) {

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al borrar");
		}

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_CREATE)) {

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al crear");
		}

		// Restaurar BBDD
		String comando = "mysql -uroot -e \"source" + getServletContext().getRealPath("gestiondocentecopia.sql") + "\"";

		Process runProcess = Runtime.getRuntime().exec(comando);
		int processComplete = 0;
		try {
			processComplete = runProcess.waitFor();

			if (processComplete == 0) {
				System.out.println("Todo correcto");

			} else {
				System.out.println("Ha habido algún error");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Redirijimos a otra pantalla y nos dice si ha ido todo bien o no
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);

	}

}
