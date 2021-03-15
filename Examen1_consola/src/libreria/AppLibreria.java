package libreria;

import java.util.Scanner;

public class AppLibreria extends AppGestion {

	public static Scanner sc = null;
	static String opcion = "";
	private static LibroDao modelo = ImplementacionLibroDao.getInstance();
	private static AppLibreria app = new AppLibreria();

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		boolean salir = true;

		do {

			pintarMenu("libro");

			System.out.println("\n Selecciona una opcion del menu:");
			opcion = sc.nextLine();

			switch (opcion) {
			case OP_LISTAR:
				app.listar();
				// TODO app.listar()
				break;
			case OP_CREAR:
				app.crear();
				break;
			case OP_ELIMINAR:
				app.eliminar();
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

	}// main

	private void eliminar() {
		// pedir id del libro que se quiere eliminar
		System.out.println("Escribe el ID del libro que quieres borrar");
		int id = Integer.parseInt(sc.nextLine());

		// Llamar al metodo delete() de la clase ImplementacionLibroDao
		if (modelo.delete(id) == false) {
			System.out.println("**El id que has introducido no existe. \n Error al borrar el libro.");
		} else {
			System.out.println("Libro borrado correctamente.");
		}

	}

	private void listar() {
		for (Libro libro : modelo.getAll()) {
			// System.out.println(libro); //Esto muestra el toString()
			System.out.println(
					String.format("%-2s / %-25s / %-4s € / %s descuento / %s / %s", libro.getId(), libro.getNombre(),
							libro.getPrecio(), libro.getDescuento(), libro.getAutor(), libro.getUrlImagen()));
		}

	}

	private void crear() {

		String nombre = "";
		double precio = 0;
		int descuento = 0;
		String autor = "";
		String urlImagen = "";

		boolean salir1 = true;
		boolean salir2 = true;
		boolean salir3 = true;

		// Pedir datos
		do {
			try {
				System.out.println("Escribe el nombre del libro.");
				nombre = sc.nextLine();
				if (nombre.length() >= 2 && nombre.length() <= 150) {
					salir1 = false;
				}

			} catch (Exception e) {
				System.out.println("Como minimo tiene que tener 2 letras y como maximo 150.");

			}

		} while (salir1);

		do {
			try {
				System.out.println("Escribe el precio del libro.");
				precio = Double.parseDouble((sc.nextLine()));
				if (precio > 0) {
					salir2 = false;
				}

			} catch (Exception e) {
				System.out.println("Tiene que ser mayor que 0.");
			}

		} while (salir2);

		do {
			try {
				System.out.println("Escribe el descuento del libro.");
				descuento = Integer.parseInt(sc.nextLine());
				if (descuento >= 0 && descuento <= 100) {
					salir3 = false;
				}

			} catch (Exception e) {
				System.out.println("Tiene que ser un numero entre 0 y 100.");
			}

		} while (salir3);

		System.out.println("Escribe el autor del libro");
		autor = sc.nextLine();

		System.out.println("Escribe la url de la imagen del libro");
		urlImagen = sc.nextLine();

		// Crear objeto libro
		Libro lib = new Libro(nombre, precio, descuento, autor, urlImagen);

		// Llamar el metodo insertar() de la clase ImplementacionLibroDao
		if (modelo.insert(lib) == true) {
			System.out.println("Libro creado correctamente.");
		} else {
			System.out.println("**El nombre del libro ya existe. \n Error al crear el libro");
		}

	}

}
