<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" />

<h1>${perro.nombre}</h1>

<table>
	 <thead>
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>RAZA</th>
				<th>PESO</th>
				<th>VACUNADO</th>
				<th>HISTORIA</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${perros}" var="perro">
				 <tr>
				 	<td>${perro.id}</td>
				 	<td><a href="perro-detalle?id=${perro.id}">${perro.nombre}</a></td>
				 	<td>${perro.raza}</td>
				 	<td>${perro.peso}</td>
				 	<td>${perro.vacunado}</td>
				 	<td>${perro.historia}</td>
				 </tr>
			 </c:forEach>
		</tbody>
	</table>

<hr>
<a href="perro-eliminar?id=${perro.id}">ELIMINAR PERRO, Cuidado no tiene vuelta atras!!!</a>


<jsp:include page="includes/pie.jsp" />	