<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
EDAD (PETICI�N) ${requestScope.edad} <br>
EDAD (SESI�N) ${sessionScope.edad} <br>
EDAD (APLIACI�N) ${applicationScope.edad}
</body>
</html>