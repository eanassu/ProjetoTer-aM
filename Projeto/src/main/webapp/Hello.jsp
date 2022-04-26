<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste de JSP</title>
</head>
<body>
Primeira página JSP<br/>
<%
String texto = "Teste JSP";
out.println(texto);
%>
<br/>
<%= texto%>
<br/>
<%
System.out.println("teste");
%>
</body>
</html>