<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<c:if test="${libros != null}">
<br />
<h2>Libro buscado</h2>
</c:if>
<br />

<c:choose>
	<c:when test="${libros != null}">
				
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
			<c:choose>
				<c:when test="${libros != null}">
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
				</c:when>
			</c:choose>
		</tbody>
	</table>
</div>
</c:when>
	<c:otherwise>
		<strong><p style="color:red">Libro no encontrado</p></strong>			
	</c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>