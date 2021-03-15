package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accesodatos.UsuarioDaoTreeMap;
import modelos.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UsuarioDaoTreeMap dao = UsuarioDaoTreeMap.getInstancia();
		Usuario usuario = dao.obtenerPorEmail(email);

		if (usuario != null && usuario.getPassword().equals(password)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("/tienda").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}

		// response.setContentType("text/plain");
		// response.getWriter().println(email + ", " + password);
	}

}
