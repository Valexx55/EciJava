<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Datos IMC Persona</title>
    <script type="text/javascript">
    function 
    </script>
</head>
<body>
<form action="./JuegoAdivinaNum" method="get">
   <label for="numero">NUMERO</label> 	
   <input name="numero" id="numero" type="number"><br><br>
  <input type="submit" value="Submit">
</form>
<c:if test="${ganador}"> 
<c:out value="${mensaje}"/> 
</c:if>
<c:if  test="${!ganador}"> 
<c:out value="${mensaje}"/> 
intentos
<c:out value="${restan_intentos}"/> 
</c:if>

</body>
</html>