package accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import modelos.Producto;

public class ProductoDaoTreeMap implements Dao<Producto> {

	private static TreeMap<Long, Producto> productos = new TreeMap<>();

	static {
		productos.put(1L, new Producto(1L, "Bunny Basic", "Comida para hamsters basica.", "imgs/bunnybasichamster.jpg",
				new BigDecimal("12.95"), 20, "Gramos", new BigDecimal("18.50"), 1));
		productos.put(2L, new Producto(2L, "Bunny Expert", "Comida para hamsters especial",
				"imgs/bunnyexperthamster.jpg", new BigDecimal("7.90"), null, "Gramos", new BigDecimal("18.50"), 1));

		for (Long id = 3L; id <= 12L; id++) {
			productos.put(id,
					new Producto(id, "Producto" + id, "Descripción" + id, "http://placeimg.com/640/480/tech?" + id,
							new BigDecimal(11 * id), id.intValue(), "Unidad" + id, new BigDecimal(10 * id),
							id.intValue()));
		}
	}

	// SINGLETON

	// Ponemos privado el constructor por defecto para que nadie pueda crear
	// instancias de esta clase de forma libre
	// Con esto evitamos la posibilidad de que nadie haga new de esta clase (salvo
	// esta clase en sí misma)
	private ProductoDaoTreeMap() {
	}

	// Creamos el único objeto que va a existir de este tipo
	private static ProductoDaoTreeMap INSTANCIA = new ProductoDaoTreeMap();

	// Creamos un método público que de acceso a la única instancia disponible
	// Desde otras clases deberemos hacer
	// ProductoDaoTreeMap dao = ProductoDaoTreeMap.getInstancia();
	// o mejor
	// Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
	public static ProductoDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productos.get(id);
	}

	@Override
	public void creat(Producto producto) {
		Long id = productos.size() == 0 ? 1L : productos.lastKey() + 1L;
		producto.setId(id);
		productos.put(id, producto);

	}

	@Override
	public void modificar(Producto producto) {
		productos.put(producto.getId(), producto);
	}

	@Override
	public void eliminar(Long id) {
		productos.remove(id);

	}

}
