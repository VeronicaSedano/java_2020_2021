package com.ipartek.formacion.spring.medicamentos;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.medicamentos.entidades.Medicamento;
import com.ipartek.formacion.spring.medicamentos.repositorios.Dao;

@SpringBootApplication
public class MedicamentosApplication implements CommandLineRunner {

	static final protected String OP_LISTAR = "1";
	static final protected String OP_CREAR = "2";
	static final protected String OP_ELIMINAR = "3";
	static final protected String OP_SALIR = "s";

	public static Scanner sc = null;
	static String opcion = "";

	public static void main(String[] args) {
		SpringApplication.run(MedicamentosApplication.class, args);
	}

	@Autowired
	private Dao<Medicamento> dao;

	@Override
	public void run(String... args) throws Exception {

		sc = new Scanner(System.in);
		boolean salir = true;

		do {

			pintarMenu("medicamentos");

			System.out.println("\n Selecciona una opcion del menu:");
			opcion = sc.nextLine();

			switch (opcion) {
			case OP_LISTAR:
				listar();
				break;
			case OP_CREAR:
				crear();
				break;
			case OP_ELIMINAR:
				eliminar();
				break;
			case OP_SALIR:
				salir = false;
				System.out.println("*** ADIOS ***");
				break;

			default:
				System.out.println(" ** por favor selecciona una opción valida ** ");
				break;
			}

		} while (salir);

		sc.close();

	}

	protected static void pintarMenu(final String nombrePojo) {

		System.out.println("");
		System.out.println("************ APP MEDICAMENTOS ***********");
		System.out.println(" " + OP_LISTAR + ".- Listar todos los " + nombrePojo);
		System.out.println(" " + OP_CREAR + ".- Crear un " + nombrePojo);
		System.out.println(" " + OP_ELIMINAR + ".- Dar de baja un " + nombrePojo);
		System.out.println(" ");
		System.out.println(" " + OP_SALIR + " - Salir");
		System.out.println("*************************************");

	}

	private void listar() {
		for (Medicamento medicamento : dao.obtenerTodos()) {
			System.out.println(medicamento);
		}
	}

	private void crear() {
		System.out.println("Escribe la referencia del medicamento");
		String referencia = sc.nextLine();
		System.out.println("Escribe el nombre del medicamento");
		String nombre = sc.nextLine();
		System.out.println("Escribe el precio del medicamento");
		double precio = Double.parseDouble(sc.nextLine());

		dao.agregar(new Medicamento(null, referencia, nombre, precio));

	}

	private void eliminar() {
		System.out.println("Escribe id del medicamento que quieres borrar");
		Long id = Long.parseLong(sc.nextLine());
		dao.borrar(id);

	}

}
