<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Your choice was</h1>
<!-- ${carrito} -->
<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Total</th>
			
		</tr>
		
	</thead>
	<tbody>
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<th>${producto.value.id}</th>
				<th>${producto.value.nombre}</th>
				<th><fmt:formatNumber type="currency" value="${producto.value.precioConDescuento}" /></th>
				<th>${producto.value.cantidad}</th>
				<!--<th><fmt:formatNumber type="currency" value="${producto.value.precioConDescuento * producto.value.cantidad}" /></th>-->
				<th><fmt:formatNumber type="currency" value="${producto.value.totalParcial}" /></th>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="5">TOTAL A PAGAR: <fmt:formatNumber type="currency" value="${totalCompra}" /></th>
		</tr>
		
	</tbody>
</table>

<button class="btn btn-primary m-3">Pay</button>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
