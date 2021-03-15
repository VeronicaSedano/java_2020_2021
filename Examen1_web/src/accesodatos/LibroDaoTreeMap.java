package accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import org.apache.commons.lang3.SerializationUtils;

import modelos.Libro;

public class LibroDaoTreeMap implements Dao<Libro> {

	private static TreeMap<Long, Libro> libros = new TreeMap<>();

	static {
		libros.put(1L, new Libro(1L, "Los futbolisimos. El misterio del jugador numero 13", new BigDecimal("13.50"), 10,
				"ROBERTO SANTIAGO", "imgs/losfutbolisimos.jpg"));
		libros.put(2L, new Libro(2L, "Los futbolisimos. El misterio de las botas magicas", new BigDecimal("9.40"), 0,
				"ROBERTO SANTIAGO", "imgs/losfutbolisimos4.jpg"));
		libros.put(3L, new Libro(3L, "Los futbolisimos. El misterio del jugador numero 13", new BigDecimal("13.50"), 10,
				"ROBERTO SANTIAGO", "imgs/losfutbolisimos.jpg"));
		libros.put(4L, new Libro(4L, "Los futbolisimos. El misterio de las botas magicas", new BigDecimal("9.40"), 0,
				"ROBERTO SANTIAGO", "imgs/losfutbolisimos4.jpg"));
		libros.put(5L, new Libro(5L, "Los futbolisimos. El misterio del jugador numero 13", new BigDecimal("13.50"), 10,
				"ROBERTO SANTIAGO", "imgs/losfutbolisimos.jpg"));
		libros.put(6L, new Libro(6L, "Los futbolisimos. El misterio de las botas magicas", new BigDecimal("9.40"), 0,
				"ROBERTO SANTIAGO", "imgs/losfutbolisimos4.jpg"));
		libros.put(7L, new Libro(7L, "Los futbolisimos. El misterio del jugador numero 13", new BigDecimal("13.50"), 10,
				"ROBERTO SANTIAGO", "imgs/losfutbolisimos.jpg"));
		libros.put(8L, new Libro(8L, "Los futbolisimos. El misterio de las botas magicas", new BigDecimal("9.40"), 0,
				"ROBERTO SANTIAGO", "imgs/losfutbolisimos4.jpg"));

	}

	// SINGLETON

	// Ponemos privado el constructor por defecto para que nadie pueda crear
	// instancias de esta clase de forma libre
	// Con esto evitamos la posibilidad de que nadie haga new de esta clase (salvo
	// esta clase en sí misma)
	private LibroDaoTreeMap() {
	}

	// Creamos el único objeto que va a existir de este tipo
	private static LibroDaoTreeMap INSTANCIA = new LibroDaoTreeMap();

	// Creamos un método público que de acceso a la única instancia disponible
	// Desde otras clases deberemos hacer
	// ProductoDaoTreeMap dao = ProductoDaoTreeMap.getInstancia();
	// o mejor
	// Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
	public static LibroDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return SerializationUtils.clone(libros.get(id));
	}

	@Override
	public void crear(Libro libro) {
		Long id = libros.size() == 0 ? 1L : libros.lastKey() + 1L;
		libro.setId(id);
		libros.put(id, libro);
	}

	@Override
	public void modificar(Libro libro) {
		libros.put(libro.getId(), libro);
	}

	@Override
	public void eliminar(Long id) {
		libros.remove(id);
	}

}
