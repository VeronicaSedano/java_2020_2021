package com.ipartek.veronica.uf1466_2.accesodatos;

import com.ipartek.veronica.uf1466_2.entidades.Libro;

public interface LibroDao extends Dao<Libro> {

	default Libro buscarPorIsbn(String isbn) {
		throw new AccesoDatosException("Metodo no implementado");
	}

}
