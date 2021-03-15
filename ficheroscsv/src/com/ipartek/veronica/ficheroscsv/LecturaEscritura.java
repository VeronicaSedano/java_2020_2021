package com.ipartek.veronica.ficheroscsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class LecturaEscritura {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("prueba.csv");
		PrintWriter pw = new PrintWriter(fw);

		pw.println("1,ana,ruiz");
		pw.println("2,juan,martinez");
		pw.println("3,marta,garcia");

		pw.close();

		// System.out.println("Escrito el fichero");

		FileReader fr = new FileReader("prueba.csv");
		BufferedReader br = new BufferedReader(fr);
		// Scanner s = new Scanner(fr);

		String linea;

		while ((linea = br.readLine()) != null) {
			System.out.println(linea);
		}

		br.close();

		String contents = new String(Files.readAllBytes(FileSystems.getDefault().getPath("prueba.csv")),
				StandardCharsets.UTF_8);

		System.out.println(contents);

		// fw = new FileWriter("datoscopia.txt");
		// fw.write(contents);
		// fw.close();

		// System.out.println("Copiado");
	}

}
