package com.ipartek.veronica.uf1466_2.accesodatos;

public class AccesoDatosException extends RuntimeException {

	private static final long serialVersionUID = 3702702119164201634L;

	public AccesoDatosException() {
		super();

	}

	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccesoDatosException(String message) {
		super(message);
	}

	public AccesoDatosException(Throwable cause) {
		super(cause);
	}

}
