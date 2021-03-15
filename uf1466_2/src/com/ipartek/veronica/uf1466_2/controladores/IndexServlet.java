package com.ipartek.veronica.uf1466_2.controladores;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ipartek.veronica.uf1466_2.accesodatos.LibroDao;
import com.ipartek.veronica.uf1466_2.accesodatos.LibroDaoMysql;
import com.ipartek.veronica.uf1466_2.entidades.Libro;

@WebServlet("/index")
@MultipartConfig
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = -5472203944254827222L;

	private static final String UPLOAD_DIRECTORY = "backups";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibroDao dao = new LibroDaoMysql();

		// Mostrar todos los libros que hay en la base de datos
		Iterable<Libro> libros = dao.obtenerTodos();

		request.setAttribute("libros", libros);

		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Poner la codificacion de entrada de datos por formulario
		request.setCharacterEncoding("utf-8");

		// Ruta
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();

		String nombreFichero = null;

		for (Part part : request.getParts()) {
			nombreFichero = part.getSubmittedFileName();

			if (nombreFichero != null && nombreFichero.trim().length() > 0) {
				part.write(uploadPath + File.separator + nombreFichero);
				break;
			}
		}

		String comando = "mysql -uroot -e \"source " + uploadPath + File.separator + nombreFichero + "\"";

		Process runProcess = Runtime.getRuntime().exec(comando);
		int processComplete = 0;
		try {
			processComplete = runProcess.waitFor();

			if (processComplete == 0) {
				// System.out.println("Todo correcto");
				request.setAttribute("alertaTexto", "Base de datos restaurada.");
				request.setAttribute("alertaNivel", "success");
			} else {
				// System.out.println("Ha habido algún error");
				request.setAttribute("alertaTexto", "Error al restaurar la base de datos");
				request.setAttribute("alertaNivel", "danger");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/vistas/restaurarBBDD.jsp").forward(request, response);

	}

}
