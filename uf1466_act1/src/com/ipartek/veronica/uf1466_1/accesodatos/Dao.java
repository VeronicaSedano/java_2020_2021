package com.ipartek.veronica.uf1466_1.accesodatos;

public interface Dao<T> {

	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("Metodo no implenetado");
	}
}
