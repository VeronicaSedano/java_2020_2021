package com.ipartek.formacion.examenrestspring.repositorios;

import com.ipartek.formacion.examenrestspring.entidades.Resenia;

public interface ReseniaDao extends Dao<Resenia> {

	Resenia insertar(Resenia resenia);

	Resenia modificar(Resenia resenia);

	void borrar(Long id);
}
