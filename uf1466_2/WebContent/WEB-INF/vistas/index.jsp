<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Lista libros</h2>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Código</th>
				<th scope="col">Título</th>
				<th scope="col">ISBN</th>
				<th scope="col">Detalles</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<th scope="row">${libro.id}</th>
					<td>${libro.titulo}</td>
					<td>${libro.isbn}</td>
					<td>
						<div class="btn-group" role="group" aria-label="Opciones">
							<a class="btn btn-primary btn-sm"
									href="detalleLibro?id=${libro.id}">Ver detalle</a> 						
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<br />
<h2>Buscar</h2>
<form action="buscar" method="post" class="needs-validation">
	
	<!-- textoBuscar -->
	<div class="form-group row">
		
		<div class="col">
			Buscar libro por ISBN: <input type="text" class="form-control" id="libroBuscado" name="libroBuscado" required>
		</div>
	</div>
	
	<div class="form-group row">
		<div class="offset-md-4 offset-lg-3 col">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>

</form>


<h2>Restaurar BBDD</h2>

<form method="post" enctype="multipart/form-data">
	Selecciona un archivo: <input type="file" name="archivo"/>
	<button type="submit" class="btn btn-primary">Crear BBDD</button>
	<p></p>
</form>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>