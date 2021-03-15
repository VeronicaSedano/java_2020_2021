<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>


<h2>BBDD</h2>
			
<c:if test="${alertaTexto != null}">
		<div class="alert alert-${alertaNivel} alert-dismissible fade show" role="alert"> ${alertaTexto}
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
			</button>
		</div>
</c:if>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>