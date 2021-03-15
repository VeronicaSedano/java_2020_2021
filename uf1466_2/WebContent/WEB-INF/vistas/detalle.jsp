<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Detalle libro con id ${libro.id}</h2>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Código</th>
				<th scope="col">Título</th>
				<th scope="col">ISBN</th>
				<th scope="col">Autor</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">${libro.id}</th>
				<td>${libro.titulo}</td>
				<td>${libro.isbn}</td>
				<td>${libro.autor.nombre} ${libro.autor.apellidos}</td>
			</tr>
		
		</tbody>
	</table>
</div>
<br />



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>