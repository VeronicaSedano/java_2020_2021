package com.ipartek.formacion.actividad3.entidades;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
	private Long id;
	private String nombre;
	private String autor;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private final Set<Resena> resenas = new HashSet<>();

}
