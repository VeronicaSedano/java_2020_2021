package com.ipartek.veronica.uf1466_1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.veronica.uf1466_1.accesodatos.ClienteDao;
import com.ipartek.veronica.uf1466_1.accesodatos.ClienteDaoMysql;
import com.ipartek.veronica.uf1466_1.entidades.Cliente;

@SpringBootApplication
public class Uf14661Application {

	private static final ClienteDao DAO = ClienteDaoMysql.getInstancia();

	public static void main(String[] args) {

		Date fechaActual = new Date();
		DateFormat formatFechaHora = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String nombreFichero = "D:\\" + formatFechaHora.format(fechaActual) + ".csv";

		FileWriter fw = null;
		try {
			fw = new FileWriter(nombreFichero);
		} catch (IOException e) {
			e.printStackTrace();
		}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fw);
		} catch (Exception e) {
			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();

		Iterable<String> columnas = DAO.cabecera();

		for (String columna : columnas) {
			sb.append(columna + ";");
		}
		String cabecera = sb.toString();

		pw.println(cabecera);

		Iterable<Cliente> clientes = DAO.obtenerTodos();
		for (Cliente cliente : clientes) {
			pw.println(cliente.getId() + ";" + cliente.getNombre() + ";" + cliente.getEmail() + ";"
					+ cliente.getTelefono() + ";" + cliente.getDireccion() + ";" + cliente.getPoblacion() + ";"
					+ cliente.getCodigopostal() + ";" + cliente.getIdentificador() + ";" + cliente.getActivo() + ";");
		}

		pw.close();
	}

}
