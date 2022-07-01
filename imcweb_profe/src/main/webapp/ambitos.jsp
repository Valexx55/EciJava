<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
EDAD (PETICIÓN) ${requestScope.edad} <br>
EDAD (SESIÓN) ${sessionScope.edad} <br>
EDAD (APLIACIÓN) ${applicationScope.edad}
</body>
</html>