<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alunos</title>
</head>
<body>

<c:import url="cabecalho.jsp"/>

<jsp:useBean id="dao" class="br.vemprafam.dao.DaoAluno"/>
<table border="1">
<tr>
<th>RA</th><th>nome</th><th>Data de Nascimento</th><th>Renda</th>
</tr>
<c:forEach var="aluno" items='${dao.alunos}' varStatus="id">
<tr bgcolor="#${id.count%2==0?'aaee88':'ffffff'}">
  <td>${aluno.ra}</td><td>${aluno.nome}</td>
  <td><fmt:formatDate value="${aluno.dataNascimento}" pattern="dd/MM/yyyy"/></td>
  <td><fmt:formatNumber value="${aluno.renda}" type="currency"/></td>
  <td><a href="excluir?ra=${aluno.ra}">excluir</a></td>
</tr>
</c:forEach>
</table>
<a href="/Projeto">voltar ao menu</a>
<br/>
<c:import url="rodape.jsp"/>
</body>
</html>