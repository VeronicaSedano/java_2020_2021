package com.ipartek.formacion.actividad3.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resena {
	private Long id;
	private String texto;
	private int libroId;

}
