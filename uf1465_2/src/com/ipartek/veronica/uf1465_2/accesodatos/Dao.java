package com.ipartek.veronica.uf1465_2.accesodatos;

public interface Dao<T> {

	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("Metodo no implementado");
	}

}
