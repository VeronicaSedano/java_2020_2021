package com.ipartek.formacion.mvc.controladores;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sesion")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Leer
		HttpSession session = request.getSession();

		String nombre = (String) session.getAttribute("nombre");
		Date fecha = (Date) session.getAttribute("fecha");
		String navegador = request.getHeader("User-Agent");

		response.setContentType("text/plain");
		response.getWriter().println(nombre);
		response.getWriter().println(fecha);
		response.getWriter().println(navegador);

		// Escribir
		session.setAttribute("nombre", nombre);
		session.setAttribute("fecha", new Date());

		response.setContentType("text/plain");
		response.getWriter().println("Escritos datos de sesión");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");

		HttpSession session = request.getSession();

		session.setAttribute("nombre", nombre);
		response.sendRedirect("sesion");
	}

}
