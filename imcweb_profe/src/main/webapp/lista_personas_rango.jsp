<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTADO PERSONAS</title>
</head>
<body>
	<!-- https://stackoverflow.com/a/1890462/4067559 
	resumen de acceso a datos
	desde JSP -->
	FECHA INICIO SERVICIO ${HORA_INICIO}  <br><br>
	${param.max} <br>
	${param.min} <br>
	${requestScope.max}  <br>
	${applicationScope.HORA_INICIO} <br><br><br>
	
	<c:if test="${listap.size() > 0}">
	Listado de personas entre ${min} y ${max} kilos
	<table>
		<tr>
			<th>ID</th>
			<th>peso</th>
			<th>Estatura</thd>
			<th>IMC NUM</thd>
			<th>IMC NOM</thd>
		</tr>
		<c:forEach items="${listap}" var="imcResultado">
			<tr>
				<td>${imcResultado.id}</td>
				<td>${imcResultado.peso}</td>
				<td>${imcResultado.estatura}</td>
				<td>${imcResultado.imc_num}</td>
				<td>${imcResultado.imc_nom}</td>
			</tr>
		</c:forEach>

	</table>
	</c:if>
	<c:if test="${listap.size() == 0}">
			LISTA VACÍA
	</c:if>
</body>
</html>