package com.ipartek.veronica.uf1465_2.entidades;

import java.util.Set;

public class Categoria {
	private Long id;
	private String nombre_categoria;

	private Set<Producto> productos;

	public Categoria(Long id, String nombre_categoria) {
		super();
		this.id = id;
		this.nombre_categoria = nombre_categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre_categoria == null) ? 0 : nombre_categoria.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre_categoria == null) {
			if (other.nombre_categoria != null)
				return false;
		} else if (!nombre_categoria.equals(other.nombre_categoria))
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre_categoria=" + nombre_categoria + "]";
	}

}
