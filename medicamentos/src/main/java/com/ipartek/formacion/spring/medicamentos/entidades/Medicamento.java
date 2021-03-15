package com.ipartek.formacion.spring.medicamentos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {

	private Long id;
	private String referencia;
	private String nombre;
	private double precio;
}
