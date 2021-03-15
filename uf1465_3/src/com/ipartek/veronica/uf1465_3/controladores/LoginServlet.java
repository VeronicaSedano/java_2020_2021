package com.ipartek.veronica.uf1465_3.controladores;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.veronica.uf1465_3.accesodatos.UsuarioDao;
import com.ipartek.veronica.uf1465_3.accesodatos.UsuarioDaoMySql;
import com.ipartek.veronica.uf1465_3.bibliotecas.Password;
import com.ipartek.veronica.uf1465_3.entidades.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(LoginServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		UsuarioDao dao = new UsuarioDaoMySql();

		Usuario usuario = dao.obtenerPorNombre(nombre);

		String hash = Password.obtenerHash(password);

		String longitud = String.valueOf(hash.length());

		LOG.info(password);
		LOG.info(hash);
		LOG.info(longitud);

		if (hash.equals(usuario.getPassword())) {
			request.getSession().setAttribute("usuario", usuario);

			request.getRequestDispatcher("/WEB-INF/vistas/saludo.jsp").forward(request, response);

		} else {
			request.setAttribute("mensaje", "El usuario o la contraseña son incorrectos");
			request.setAttribute("nivel", "danger");

			request.setAttribute("nombre", nombre);

			doGet(request, response);
		}
	}
}
