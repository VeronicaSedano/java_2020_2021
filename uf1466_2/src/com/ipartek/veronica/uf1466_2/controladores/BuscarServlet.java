package com.ipartek.veronica.uf1466_2.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.veronica.uf1466_2.accesodatos.LibroDao;
import com.ipartek.veronica.uf1466_2.accesodatos.LibroDaoMysql;
import com.ipartek.veronica.uf1466_2.entidades.Libro;

@WebServlet("/buscar")
public class BuscarServlet extends HttpServlet {

	private static final long serialVersionUID = -5824929793028271617L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recoger el isbn del libro que queremos buscar
		String libroBuscado = request.getParameter("libroBuscado");

		Libro libro = null;
		ArrayList<Libro> libros = new ArrayList<>();

		LibroDao dao = new LibroDaoMysql();

		// Llamamos al metodo buscarPorIsbn para buscar el libro
		libro = dao.buscarPorIsbn(libroBuscado);

		if (libro != null) {
			libros.add(libro);
			request.setAttribute("libros", libros);
		}

		// Mostramos el resultado en otra pagina
		request.getRequestDispatcher("/WEB-INF/vistas/libroBuscado.jsp").forward(request, response);

	}

}
