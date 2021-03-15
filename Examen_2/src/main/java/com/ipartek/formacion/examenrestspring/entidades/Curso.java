package com.ipartek.formacion.examenrestspring.entidades;

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
public class Curso {
	private Long id;
	private String nombre;
	private String identificador;
	private int nHoras;
	private String profesor;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private final Set<Resenia> resenas = new HashSet<>();

}
