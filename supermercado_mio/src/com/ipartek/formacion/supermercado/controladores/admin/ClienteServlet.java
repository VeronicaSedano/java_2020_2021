package com.ipartek.formacion.supermercado.controladores.admin;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.modelos.Cliente;

@WebServlet("/admin/cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Logger LOGGER = Logger.getLogger(ClienteServlet.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/admin/cliente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String cif = request.getParameter("cif");
		String fechaNacimiento = request.getParameter("fecha-nacimiento");
		
		Cliente cliente = new Cliente(id, nombre, apellidos, cif, fechaNacimiento);
		
		LOGGER.info(cliente.toString());
		
		if(cliente.isCorrecto()) {
			LOGGER.info("Cliente correcto");
			response.sendRedirect(request.getContextPath() + "/admin/index");
		} else {
			LOGGER.warning("Cliente INcorrecto");
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("/WEB-INF/vistas/admin/cliente.jsp").forward(request, response);
		}
	}
}
