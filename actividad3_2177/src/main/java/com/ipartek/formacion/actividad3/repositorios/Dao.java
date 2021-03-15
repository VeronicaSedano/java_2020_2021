package com.ipartek.formacion.actividad3.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();

	T obtenerPorId(Long id);

}
