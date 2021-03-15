package com.ipartek.veronica.uf1466_1.accesodatos;

import com.ipartek.veronica.uf1466_1.entidades.Cliente;

public interface ClienteDao extends Dao<Cliente> {

	default Iterable<String> cabecera() {
		throw new AccesoDatosException("Metodo no implementado");
	}

}
