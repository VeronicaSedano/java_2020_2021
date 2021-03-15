package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accesodatos.Dao;
import accesodatos.LibroDaoTreeMap;
import modelos.Libro;

@WebServlet("/inicio")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao<Libro> dao = LibroDaoTreeMap.getInstancia();
		Iterable<Libro> libros = dao.obtenerTodos();
		request.setAttribute("libros", libros);
		request.getRequestDispatcher("/WEB-INF/vistas/principal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
