<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Crear libro</h1>

<form action="" method="post" class="needs-validation">

	<div class="form-group row">
		<label for="id" class="col-md-4 col-lg-3 col-form-label">Id</label>
		<div class="col">
			<input type="text" class="form-control ${libro.errorId != null ? 'is-invalid' : '' }" id="id" name="id" value="${libro.id}"
				placeholder="Id del libro">
			<div class="valid-feedback">Id correcto</div>
			<div class="invalid-feedback">${libro.errorId != null ? libro.errorId : 'Debes introducir un numero'}</div>
		</div>
	</div>

	<div class="form-group row">
		<label for="nombre" class="col-md-4 col-lg-3 col-form-label">Nombre</label>
		<div class="col">
			<input type="text" class="form-control ${libro.errorNombre != null ? 'is-invalid' : '' }" id="nombre" name="nombre" value="${libro.nombre}" placeholder="Debe introducir una cadena de texto. Mínimo 2 letras y máximo 150.">
			<div class="valid-feedback">Nombre correcto</div>
			<div class="invalid-feedback">${libro.errorNombre != null ? libro.errorNombre : 'Debe introducir una cadena de texto. Mínimo 2 letras y máximo 150'}</div>
		</div>
	</div>



	<div class="form-group row">
		<label for="precio" class="col-md-4 col-lg-3 col-form-label">Precio</label>
		<div class="input-group col">
			<input type="number" step=".01" min="0" class="form-control ${libro.errorPrecio != null ? 'is-invalid' : '' }"
				id="precio" name="precio" value="${libro.precio}">

			<div class="input-group-append">
				<span class="input-group-text rounded-right">€</span>
			</div>

			<div class="valid-feedback">Precio correcto</div>
			<div class="invalid-feedback">${libro.errorPrecio != null ? libro.errorPrecio : 'Debe rellenarse, ser mayor que 0 y tener 2 decimales' }</div>
		</div>
	</div>

	
	<div class="form-group row">
		<label for="descuento" class="col-md-4 col-lg-3 col-form-label">Descuento</label>
		<div class="input-group col">
			<input type="number" class="form-control ${libro.errorDescuento != null ? 'is-invalid' : '' }" id="descuento" name="descuento" value="${libro.descuento}"
				name="cantidad" />
			<div class="input-group-append">
				<span class="input-group-text rounded-right">%</span>
			</div>
			
			<div class="valid-feedback">Descuento correcto</div>
			<div class="invalid-feedback">${libro.errorDescuento != null ? libro.errorDescuento : 'Debe ser un valor numerico entre 0 y 100'}</div>
		</div>
	</div>
	
	<div class="form-group row">
		<div class="offset-md-4 offset-lg-3 col">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>

</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
