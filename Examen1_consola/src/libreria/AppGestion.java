package libreria;

public abstract class AppGestion {

	static final protected String OP_LISTAR = "1";
	static final protected String OP_CREAR = "2";
	static final protected String OP_ELIMINAR = "3";
	static final protected String OP_SALIR = "s";

	protected static void pintarMenu(final String nombrePojo) {

		System.out.println("");
		System.out.println("************ APP LIBRERIA ***********");
		System.out.println(" " + OP_LISTAR + ".- Listar todos los " + nombrePojo);
		System.out.println(" " + OP_CREAR + ".- Crear un " + nombrePojo);
		System.out.println(" " + OP_ELIMINAR + ".- Dar de baja un " + nombrePojo);
		System.out.println(" ");
		System.out.println(" " + OP_SALIR + " - Salir");
		System.out.println("*************************************");

	}

}
