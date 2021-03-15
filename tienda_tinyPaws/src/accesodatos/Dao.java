package accesodatos;

/**
 * Interface que contiene los metodos que se van a implementar posteriormente en
 * ProductoDaoTreeMap.java <br>
 * Iterable es el generico de las listas.
 * 
 * @author Veronica
 *
 * @param <T>
 */

public interface Dao<T> {

	Iterable<T> obtenerTodos();

	T obtenerPorId(Long id);

	void creat(T objeto);

	void modificar(T objeto);

	void eliminar(Long id);

}
