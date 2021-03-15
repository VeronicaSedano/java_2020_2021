package com.ipartek.veronica.uf1466_2.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
	private Long id;
	private String nombre;
	private String apellidos;

}
