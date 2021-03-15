package com.ipartek.veronica.uf1465_3.accesodatos;

import com.ipartek.veronica.uf1465_3.entidades.Usuario;

public interface UsuarioDao extends Dao<Usuario> {

	default Usuario obtenerPorNombre(String nombre) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
