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
	<table>
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Peso</th>
			<th>Estatura</thd>
			<th>Fecha Nac</th>
		</tr>
		<c:forEach items="${listap}" var="persona">
			<tr>
				<td>${persona.id}</td>
				<td>${persona.nombre}</td>
				<td>${persona.peso}</td>
				<td>${persona.altura}</td>
				<td>${persona.fecha_nac}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>