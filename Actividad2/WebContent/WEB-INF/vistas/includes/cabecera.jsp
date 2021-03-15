<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_ES"/> 
<!DOCTYPE html>
<html>
<head>
<%-- <base href="/Actividad2/" /> --%>
 <base href="${pageContext.request.contextPath}/" />
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- FontAwesome -->
<link rel="stylesheet" href="css/all.min.css">
<!-- Hoja de estilos personalizada -->
<link rel="stylesheet" href="css/myStyles.css">
    <!-- Titulo -->
	<title>Actividad 2 (9-12-2020)</title>
</head>
<body id="top">
 <header class="sticky-top">

        <nav class="navbar navbar-light navbar-expand-md" style="background-color: #7e55ee;">
            <a class="navbar-brand" href="#">
                <img src="imgs/iconoham.png" width="40" height="40" class="d-inline-block align-top" alt="">
                Shop
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01"
                aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <div class="navbar-nav mr-auto ml-auto text-center" id="enlaces">
                    <li><a href="#" class="nav-item nav-link active">HOME</a></li>
                    <li><a href="carro" class="nav-item nav-link">CARRITO</a></li>
                </div>
            </div>
        </nav>


    </header>
