package com.ipartek.veronica.uf1466_act2.controladores;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "backups";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String archivo = request.getParameter("archivo");

		String dbUserName = "root";
		String dbPassword = "";
		// String source = "C:/backups/" + archivo;
		// String source = getServletContext().getRealPath("") + archivo;
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();

		String nombreFichero = null;
		String fileRestore = "";

		for (Part part : request.getParts()) {
			nombreFichero = part.getSubmittedFileName();

			if (nombreFichero != null && nombreFichero.trim().length() > 0) {
				fileRestore = uploadPath + File.separator + nombreFichero;
				part.write(uploadPath + File.separator + nombreFichero);
			}
		}

		String[] restoreCmd = new String[] { "mysql ", "--user=" + dbUserName, "--password=" + dbPassword, "-e",
				"source " + uploadPath };

		Process runProcess = Runtime.getRuntime().exec(restoreCmd);
		int processComplete = 0;
		try {
			processComplete = runProcess.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			if (processComplete == 0) {
				System.out.println("Todo correcto");
			} else {
				System.out.println("Ha habido algún error");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
