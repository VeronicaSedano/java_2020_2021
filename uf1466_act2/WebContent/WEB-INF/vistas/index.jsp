<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Lista libros</h2>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<caption>Listado de libros</caption>
		<thead class="thead-dark">
			<tr>
				<th scope="col">Código</th>
				<th scope="col">Título</th>
				<th scope="col">ISBN</th>
				<th scope="col">Autor</th>
				<th scope="col">Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<th scope="row">${libro.id}</th>
					<td>${libro.titulo}</td>
					<td>${libro.ISBN}</td>
					<td>${libro.autor.nombre} ${libro.autor.apellidos}</td>
					<td>
						<div class="btn-group" role="group" aria-label="Opciones">
							<a class="btn btn-primary btn-sm"
									href="libro-detalle?id=${libro.id}">Ver</a> 						
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<br />

<h2>Restaurar BBDD</h2>

<form method="post">
	
	<div class="form-group row">
		<div class="offset-sm-2 col-sm-10">
			Selecciona un archivo: <input type="file" name="archivo"/>
			<button type="submit" class="btn btn-primary">Crear BBDD</button>
		</div>
	</div>
</form>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>