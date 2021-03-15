package modelos;

import java.io.Serializable;
import java.math.BigDecimal;

public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	private BigDecimal precio;
	private int descuento;

	private boolean correcto = true;

	private String errorId;
	private String errorNombre;
	private String errorPrecio;
	private String errorDescuento;

	// CONSTRUCTOR NORMAL
	public Libro(long id, String nombre, BigDecimal precio, int descuento) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);

	}

	// CONSTRUCTOR CON TODOS LOS ATRIBUTOS STRING
	public Libro(String id, String nombre, String precio, String descuento) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);

	}

	// GETTERS Y SETTERS ESPECIALES
	private void setDescuento(String descuento) {
		try {
			setDescuento(Integer.parseInt(descuento));
		} catch (NumberFormatException e) {
			setErrorDescuento("El descuento debe ser un número entero");
		}
	}

	private void setPrecio(String precio) {
		System.out.println(precio);
		try {
			if (precio.matches("\\d+\\.\\d\\d")) {
				setPrecio(new BigDecimal(precio));
			} else {
				setErrorPrecio("El numero tiene que tener dos decimales.");
			}

		} catch (Exception e) {
			setErrorPrecio("El precio no tiene un formato correcto");
		}
	}

	private void setId(String id) {
		try {
			setId(id.trim().length() != 0 ? Long.parseLong(id) : null);
		} catch (NumberFormatException e) {
			setErrorId("El id debe ser numérico");
		}
	}

	// GETTERS Y SETTERS NORMALES
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id == null || id <= 0) {
			setErrorId("Debes introducir un id. No se admiten ids inferiores o iguales a 0");
		}
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 3 || nombre.trim().length() > 150
				|| !nombre.matches("[A-Z][a-z]*")) {
			setErrorNombre("Debe introducir una cadena de texto con minimo 2 letras y maximo 150.");
		}
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			setErrorPrecio("El numero tiene que ser mayor que 0");
		}

		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		if (descuento != null && (descuento < 0 || descuento > 100)) {
			setErrorDescuento("El descuento debe estar comprendido entre 0 y 100");
		}
		this.descuento = descuento;
	}

	// GETTERS Y SETTERS ERRORES
	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		correcto = false;
		this.errorId = errorId;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		correcto = false;
		this.errorNombre = errorNombre;
	}

	public String getErrorPrecio() {
		return errorPrecio;
	}

	public void setErrorPrecio(String errorPrecio) {
		correcto = false;
		this.errorPrecio = errorPrecio;
	}

	public String getErrorDescuento() {
		return errorDescuento;
	}

	public void setErrorDescuento(String errorDescuento) {
		correcto = false;
		this.errorDescuento = errorDescuento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + descuento;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		Libro other = (Libro) obj;
		if (descuento != other.descuento)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", correcto=" + correcto + ", errorId=" + errorId + ", errorNombre=" + errorNombre + ", errorPrecio="
				+ errorPrecio + ", errorDescuento=" + errorDescuento + "]";
	}

}
