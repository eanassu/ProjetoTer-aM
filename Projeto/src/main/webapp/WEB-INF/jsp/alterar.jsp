<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Dados</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({dateFormat:"dd/mm/yy"});
  } );
  </script>
</head>
<body>
<form action="ServletControle" method="get">
<input type="hidden" name="op" value="Editar">
RA:<input type="text" name="ra" value="${aluno.ra}" readonly/><br/>
Nome:<input type="text" name="nome" value="${aluno.nome}"><br/>
data de nascimento:<input type="text" name="dataNascimento" id="datepicker" value="${aluno.dataNascimentoFormatada}"/><br/>
renda: <input type="text" name="renda" value="${aluno.renda}"/><br/>
email: <input type="text" name="email" value="${aluno.email}"/><br/>
<input type="submit" value="Enviar"/>
</form>
<a href='/Projeto'>voltar ao menu</a>
</body>
</html>