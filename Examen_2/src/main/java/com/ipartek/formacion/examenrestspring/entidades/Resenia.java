package com.ipartek.formacion.examenrestspring.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resenia {
	private Long id;
	private String descripcion;
	private int alumnoCodigo;
	private int cursoCodigo;

}
