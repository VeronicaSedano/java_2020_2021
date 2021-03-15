package com.ipartek.formacion.mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie-nombre")
public class CookieNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		String nombre = "";
		String color = "";

		for (Cookie cookie : cookies) {

			if (cookie.getName().equals("nombre")) {

				nombre = cookie.getValue();
			}

			if (cookie.getName().equals("color")) {

				color = cookie.getValue();
			}

		}

		response.setContentType("text/plain");
		response.getWriter().println("Nombre: " + nombre + "\n");
		response.getWriter().println("Color: " + color);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String color = request.getParameter("color");

		Cookie cookie_nombre = new Cookie("nombre", nombre);
		Cookie cookie_color = new Cookie("color", color);

		response.addCookie(cookie_nombre);
		response.addCookie(cookie_color);

		response.sendRedirect("cookie-nombre");
		response.sendRedirect("cookie-color");

	}

}
