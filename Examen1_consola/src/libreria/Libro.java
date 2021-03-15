package libreria;

public class Libro implements Comparable<Libro> {

	private int id;
	private String nombre;
	private double precio;
	private int descuento;
	private String autor;
	private String urlImagen;

	public Libro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
		this.descuento = 0;
		this.autor = "anonimo";
		this.urlImagen = "imgs/imagen.jpg";

	}

	public Libro(int id, String nombre, double precio, int descuento, String autor, String urlImagen) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.autor = autor;
		this.urlImagen = urlImagen;
	}

	public Libro(String nombre, double precio, int descuento, String autor, String urlImagen) {
		this();
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.autor = autor;
		this.urlImagen = urlImagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + descuento;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((urlImagen == null) ? 0 : urlImagen.hashCode());
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
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (descuento != other.descuento)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		if (urlImagen == null) {
			if (other.urlImagen != null)
				return false;
		} else if (!urlImagen.equals(other.urlImagen))
			return false;
		return true;
	}

	@Override
	public int compareTo(Libro o) {
		// Si el resultado es positivo es mayor, si es negativo es menor y si es 0 es
		// igual.
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + ", autor="
				+ autor + ", urlImagen=" + urlImagen + "]";
	}

}
