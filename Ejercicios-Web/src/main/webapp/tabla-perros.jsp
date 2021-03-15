<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="includes/cabecera.jsp" />
	<h1>${mensaje}</h1>
	
	<p>* Si queremos ver la historia del perro, tendremos que acceder a sus detalles</p>
	
	 <table>
	 <thead>
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>RAZA</th>
				<th>PESO</th>
				<th>VACUNADO</th>
				<th>HISTORIA</th>
				<th>ACCIONES</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${perros}" var="perro">
				 <tr>
				 	<td>${perro.id}</td>
				 	<td><a href="perro-detalle?id=${perro.id}">${perro.nombre}</a></td>
				 	<td>${perro.raza}</td>
				 	<td>${perro.peso}</td>
				 	<td>${ (perro.vacunado) ? 'Si' : 'No' }</td>
				 	<td>${perro.historia}</td>
				 	<td class="flex">
				 		<a href="perro-editar?id=${perro.id}"><i class="fa fa-pencil"></i></a>
				 		<a href="perro-detalle?id=${perro.id}"><i class="fa fa-eye"></i></a>
				 		<a href="perro-eliminar?id=${perro.id}"><i class="fa fa-trash"></i></a>
				 	</td>
				 </tr>
			 </c:forEach>
		</tbody>
	</table>
	 
	 
	 
	
<jsp:include page="includes/pie.jsp" />