package com.ipartek.formacion.examenrestspring.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();

	T obtenerPorId(Long id);

}
