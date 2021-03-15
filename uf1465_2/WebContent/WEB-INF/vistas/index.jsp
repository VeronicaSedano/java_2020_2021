<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Productos</h1>

<table class="table table-striped table-bordered table-hover table-sm">
		<caption>Listado de productos</caption>
		<thead>
			<tr>
				<th scope="col">Id Producto</th>
				<th scope="col">Nombre producto</th>
				<th scope="col">Precio producto</th>
				<th scope="col">Categoria</th>
				<th scope="col">Nombre Categoria</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<th scope="row">${p.id}</th>
					<td>${p.nombre}</td>
					<td>${p.precio}</td>
					<td>${p.categoria.id}</td>
					<td>${p.categoria.nombre_categoria}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>