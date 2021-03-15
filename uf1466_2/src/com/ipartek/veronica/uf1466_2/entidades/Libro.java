package com.ipartek.veronica.uf1466_2.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
	private Long id;
	private String titulo;
	private String isbn;

	private Autor autor;

}
