<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos IMC Personas</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Peso</th>
			<th>Estatura</thd>
			<th>IMC_numérico</th>
			<th>IMC_nominal</th>
		</tr>
		<c:forEach items="${lista_imcs}" var="imc_item">
			<tr>
				<td>${imc_item.id}</td>
				<td>${imc_item.peso}</td>
				<td>${imc_item.estatura}</td>
				<td>${imc_item.imc_num}</td>
				<td>${imc_item.imc_nom}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>