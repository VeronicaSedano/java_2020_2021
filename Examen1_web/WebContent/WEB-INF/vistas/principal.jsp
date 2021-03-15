<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>


	<h1>Lista libros</h1>
	
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-4">
		<c:forEach items="${libros}" var="libro">
			<div class="col mb-4">
				<div class="card h-100">
					<img src="${libro.urlImagen}" class="card-img-top" alt="" width=60>
					<hr>
					<div class="card-body">
						<a class="nav-link text-right" href="#"><i class="far fa-heart"></i></a>
						<p class="card-text">${libro.nombre}</p>
						<p class="card-text"><strong>${libro.autor}</strong></p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
