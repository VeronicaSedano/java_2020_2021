package com.reguera.uf2177.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resena {

	private int id;
	private String texto;
	private int libros_id;

}
