package com.ipartek.veronica.uf1466_act2.accesodatos;

public interface Dao<T> {

	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("Metodo no implementado");
	}

	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("Metodo no implementado");
	}
}
