package com.reguera.uf2177.entidades;

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

	private int id;
	private String nombre;
	private String autor;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private final Set<Resena> resenas = new HashSet<>();

}
