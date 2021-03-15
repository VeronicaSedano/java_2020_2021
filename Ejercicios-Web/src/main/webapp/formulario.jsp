<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" />

<h2>Dar de alta un perro</h2>
<h3>Formulario</h3>
<p></p>

<form method="post" action="perro-controller">
	<p>Esto envia datos por POST al controlador</p>
	<div class="form-group">
		<label for="nombre">Nombre:</label>
		<input type="text" id="nombre" name="nombre" placeholder="Nombre del perro" autofocus required>
	</div>
	
	<div class="form-group">
		<label for="raza">Raza:</label>
		<input type="text" id="raza" name="raza" placeholder="Raza del perro" required>
	</div>
	
	<div class="form-group">
		<label for="peso">Peso: </label>
		<input type="text" id="peso" name="peso" placeholder="Peso del perro" required>
	</div>
	
	<div class="form-group">
		<label for="vacunado">Marca si esta vacunado:</label>
		<input id="vacunado" type="checkbox" class="w-7" name="vacunado">
	</div>
	
	<div class="form-group">
		<label for="historia">Historia:</label>
		<textarea id="historia" name="historia" cols="30" rows="5" placeholder="Cuentame la historia del perro"></textarea>	
	</div>
	<div class="form-group" >
		<input class="boton" type="submit" value="Guardar datos">
	</div>
</form>

<jsp:include page="includes/pie.jsp" />	