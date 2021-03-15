<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Edición de libro</h1>

<form action="" method="post" class="needs-validation" novalidate>
	<%--<input type="hidden" name="id" value="" />--%>

	<div class="form-group row">
		<label for="id" class="col-md-4 col-lg-3 col-form-label">Id</label>
		<div class="col">
			<input type="text" class="form-control" id="id" name="id" pattern="\d{1,3}" placeholder="Id del producto" required>
			<div class="valid-feedback">Id correcto</div>
			<div class="invalid-feedback">El id tiene que ser un numero con 3 digitos o menos.</div>
		</div>
	</div>

	<div class="form-group row">
		<label for="nombre" class="col-md-4 col-lg-3 col-form-label">Nombre</label>
		<div class="col">
			<input type="text" class="form-control" id="nombre" name="nombre" pattern="\p{Lu}[\p{Ll} ]{1,150}"
				placeholder="Debe introducir un nombre y una descripcion. Mínimo 2 letras y maximo 150." required>
			<div class="valid-feedback">Nombre correcto</div>
			<div class="invalid-feedback">Debes introducir un texto con mínimo 2 letras y maximo 150.</div>
		</div>
	</div>
	
	<div class="form-group row">
		<label for="precio" class="col-md-4 col-lg-3 col-form-label">Precio</label>
		<div class="input-group col">
			<input type="text" class="form-control"
				id="precio" name="precio" pattern="\d+.\d\d" required>

			<div class="input-group-append">
				<span class="input-group-text rounded-right">€</span>
			</div>

			<div class="valid-feedback">Precio correcto</div>
			<div class="invalid-feedback">Debes escribir un numero mayor que cero y con dos decimales</div>
		</div>
	</div>
	
	
	<div class="form-group row">
		<label for="descuento" class="col-md-4 col-lg-3 col-form-label">Descuento</label>
		<div class="input-group col">
			<input type="number" class="form-control" id="descuento" name="descuento" name="descuento" required/>
			<div class="input-group-append">
				<span class="input-group-text rounded-right">%</span>
			</div>
			
			<div class="valid-feedback">Descuento correcto</div>
			<div class="invalid-feedback">Debe ser un numero entre 0 y 100</div>
		</div>
	</div>
	
	<div class="form-group row">
		<label for="autor" class="col-md-4 col-lg-3  col-form-label">Autor</label>
		<div class="col">
			<input type="text" class="form-control" id="autor" name="autor" pattern="\p{Lu}[\p{Ll} ]{1,150}"
				placeholder="Debe ser una cadena de texto" required>
			<div class="valid-feedback">Autor correcto</div>
			<div class="invalid-feedback">Debes introducir una cadena de texto.</div>
		</div>
	</div>
	
	<div class="form-group row">
		<label for="imagen" class="col-md-4 col-lg-3 col-form-label">Imagen</label>
		<div class="col">
			<input type="text" class="form-control" id="imagen" name="imagen"
				placeholder="URL de la imagen a mostrar del producto">
			<div class="valid-feedback">Imagen correcto</div>
		</div>
	</div>
	
	<div class="form-group row">
		<div class="offset-md-4 offset-lg-3 col">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>

</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
