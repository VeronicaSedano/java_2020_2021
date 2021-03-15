package com.ipartek.veronica.uf1466_1.controladores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.veronica.uf1466_1.accesodatos.ClienteDao;
import com.ipartek.veronica.uf1466_1.accesodatos.ClienteDaoMysql;
import com.ipartek.veronica.uf1466_1.entidades.Cliente;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClienteDao dao = ClienteDaoMysql.getInstancia();

		Date fechaActual = new Date();
		DateFormat formatFechaHora = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String nombreFichero = "D:\\" + formatFechaHora.format(fechaActual) + ".csv";

		FileWriter fw = null;
		fw = new FileWriter(nombreFichero);

		PrintWriter pw = null;
		pw = new PrintWriter(fw);

		StringBuilder sb = new StringBuilder();

		Iterable<String> columnas = dao.cabecera();

		for (String columna : columnas) {
			sb.append(columna + ";");
		}
		String cabecera = sb.toString();

		pw.println(cabecera);

		Iterable<Cliente> clientes = dao.obtenerTodos();
		for (Cliente cliente : clientes) {
			pw.println(cliente.getId() + ";" + cliente.getNombre() + ";" + cliente.getEmail() + ";"
					+ cliente.getTelefono() + ";" + cliente.getDireccion() + ";" + cliente.getPoblacion() + ";"
					+ cliente.getCodigopostal() + ";" + cliente.getIdentificador() + ";" + cliente.getActivo() + ";");
		}

		pw.close();
		fw.close();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}

		response.sendRedirect(request.getContextPath() + "D:\\" + formatFechaHora.format(fechaActual) + ".csv");

	}

}
