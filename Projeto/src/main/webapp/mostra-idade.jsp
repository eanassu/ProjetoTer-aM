<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste</title>
</head>
<body>
Teste dos par�metros:<br/>
A idade � ${param.idade}
<jsp:useBean id="aluno" class="br.vemprafam.pojo.Aluno"/>
Nome:${aluno.nome}
</body>
</html>