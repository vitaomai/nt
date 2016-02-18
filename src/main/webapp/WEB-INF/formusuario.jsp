<%@page import="br.com.nettreinos.persistencia.entidade.Usuario" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Usuario usu = (Usuario)request.getAttribute("usu"); %>
	<form action="usucontroller.do" method="post">
		Id: <input type="text" name="id_usuario" value="<% out.print(usu.getId_Usuario());%>" /><br>
		Login: <input type="text" name="login" value="<%=usu.getLogin()%>" /><br>
		Senha: <input type="text" name="senha" value="<%=usu.getSenha()%>" /><br>
		Tipo usuario: <input type="text" name="id_tipousuario" value="<%=usu.getId_TipoUsuario()%>" /> <br>
		Ativo: <input type="checkbox" name="ativo" ><br>  
		<input type="submit" name="Salvar"/>
	</form>

</body>
</html>