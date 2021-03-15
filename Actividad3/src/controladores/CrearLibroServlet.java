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

@WebServlet("/crearlibro")
public class CrearLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recoger información de la petición

		String id = request.getParameter("id");

		// 2. Poner información dentro de un modelo
		// 3. Tomar decisiones según lo recibido

		if (id != null) {
			Dao<Libro> dao = LibroDaoTreeMap.getInstancia();

			Libro libro = dao.obtenerPorId(Long.parseLong(id));

			// 4. Generar modelo para la vista

			request.setAttribute("libro", libro);
		}

		// 5. Redirigir a otra vista
		request.getRequestDispatcher("/WEB-INF/vistas/crearlibro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Cambiar codificación de entrada de datos de formulario de Windows-1252 a UTF8

		request.setCharacterEncoding("utf-8");

		// 1. Recoger información de la petición

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String descuento = request.getParameter("descuento");

		// 2. Poner información dentro de un modelo

		Libro libro = new Libro(id, nombre, precio, descuento);

		// 3. Tomar decisiones según lo recibido

		if (!libro.isCorrecto()) {
			// 4. Generar modelo para la vista
			request.setAttribute("libro", libro);
			// 5. Redirigir a otra vista
			request.getRequestDispatcher("/WEB-INF/vistas/crearlibro.jsp").forward(request, response);
			return;
		}

		Dao<Libro> dao = LibroDaoTreeMap.getInstancia();

		String mensaje;

		// Crear libro
		dao.crear(libro);
		mensaje = "Se ha creado el libro correctamente";

		// 4. Generar modelo para la vista

		request.setAttribute("alertaTexto", mensaje);
		request.setAttribute("alertaNivel", "success");

		// 5. Redirigir a otra vista

		request.getRequestDispatcher("/inicio").forward(request, response);
	}

}
