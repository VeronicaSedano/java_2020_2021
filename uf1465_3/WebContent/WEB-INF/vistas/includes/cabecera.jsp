<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="es">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<base href="${pageContext.servletContext.contextPath}/" />

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<title>Uf1465 - Actividad 3</title>

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">uf1465_3</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav">
				<c:choose>
					<c:when test="${sessionScope.usuario != null}">
						<li class="nav-item active"><span class="navbar-text">${sessionScope.usuario.nombre}</span></li>
						<li class="nav-item active"><a class="nav-link" href="logout">Logout</a>
						</li>
					</c:when>
				</c:choose>
			</ul>
		</div>
	</nav>

	<c:if test="${mensaje != null}">
		<div class="alert alert-${nivel} alert-dismissible fade show"
			role="alert">
			${mensaje}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>

	<main class="container">