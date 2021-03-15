<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Make your order</h1>

<form action="agregartodoalcarrito" method="get">
<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
			
		</tr>
		
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="producto">
			<tr>
				<th>${producto.id}</th>
				<th>${producto.nombre}</th>
				<th><fmt:formatNumber type="currency" value="${producto.precioConDescuento}" /></th>
				<th><input type="number"
									class="form-control text-center font-weight-bold" placeholder=""
									aria-label="Cantidad" value="0" name="${producto.id}"
									min="0" /></th>
				
			</tr>
		</c:forEach>
	</tbody>
</table>

<button class="btn btn-primary mb-3">Process Request</button>
</form>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
