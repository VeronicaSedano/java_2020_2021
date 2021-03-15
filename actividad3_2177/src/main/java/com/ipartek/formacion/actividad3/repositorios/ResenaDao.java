package com.ipartek.formacion.actividad3.repositorios;

import com.ipartek.formacion.actividad3.entidades.Resena;

public interface ResenaDao extends Dao<Resena> {

	Resena insertar(Resena resena);
}
