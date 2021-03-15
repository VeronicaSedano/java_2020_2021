package com.reguera.uf2177.repositorio;

public interface LibroDao<T> {

	Iterable<T> obtenerTodos();

	T obtenerPorId(int id);

	T obtenerPorIdConColeccion(int id);

}
