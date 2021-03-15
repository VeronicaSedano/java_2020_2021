package com.ipartek.veronica.uf1466_2.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.veronica.uf1466_2.accesodatos.LibroDao;
import com.ipartek.veronica.uf1466_2.accesodatos.LibroDaoMysql;
import com.ipartek.veronica.uf1466_2.entidades.Libro;

@WebServlet("/detalleLibro")
public class DetalleLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibroDao dao = new LibroDaoMysql();

		// Recoger el id del libro
		String id = request.getParameter("id");

		if (id != null) {
			// Llamar al metodo obtenerPorId
			Libro libro = dao.obtenerPorId(Long.parseLong(id));

			request.setAttribute("libro", libro);
		}

		// Ir a la pagina donde se visualiza el detalle del libro
		request.getRequestDispatcher("/WEB-INF/vistas/detalle.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Ir a inicio
		request.getRequestDispatcher("/index").forward(request, response);
	}

}
