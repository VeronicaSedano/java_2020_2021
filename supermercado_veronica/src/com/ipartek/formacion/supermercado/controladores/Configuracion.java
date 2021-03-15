package com.ipartek.formacion.supermercado.controladores;

import com.ipartek.formacion.supermercado.accesodatos.Dao;
import com.ipartek.formacion.supermercado.accesodatos.DaoUsuario;
import com.ipartek.formacion.supermercado.accesodatos.ProductoDaoMySql;
import com.ipartek.formacion.supermercado.accesodatos.UsuarioDaoMySql;
import com.ipartek.formacion.supermercado.modelos.Producto;

public class Configuracion {
	// TREEMAP
	// public static DaoUsuario daoUsuarios = UsuarioDaoTreeMap.getInstancia();
	// public static Dao<Producto> daoProductos = ProductoDaoTreeMap.getInstancia();

	// MYSQL
	public static DaoUsuario daoUsuarios = UsuarioDaoMySql.getInstancia();
	public static Dao<Producto> daoProductos = ProductoDaoMySql.getInstancia();
}
