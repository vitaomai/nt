<%@page import="br.com.nettreinos.persistencia.entidade.Usuario" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html lang="pt-br">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de usuários</title>
	<link rel="stylesheet" href="../Estilos/estilo.css">
	
</head>
<body>
	<div id="paginaHome">

<table border="0" width="980">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
		</td></tr>
	<tr valign="top">
		<td width="180"><%@include file="menu.jsp" %> </td>
		<td> 
			<p><h1>Usuarios - Listagem </h1></p>
			<p> Nesta Página são apresentados todos os usuários do Sistema Nettreinos.<br> </p>
			<%List<Usuario> lista = (List<Usuario>)request.getAttribute("lista");%>
			<table>
				<tr> 
					<th> ID </th> 
					<th> Login </th>
					<th> Senha </th>
					<th> Id Tipo User </th>		
					<th> Ativo (s/n)</th>
					<th> Ação</th>
				</tr>
			
			<%for(Usuario u:lista){%>
				<tr>
					<td><% out.print(u.getId_Usuario());%></td>
					<td><%=u.getLogin()%></td>
					<td><%=u.getSenha()%></td>
					<td><%=u.getId_TipoUsuario() %>
					<td><%=u.getAtivo() %></td>
					<td><a href="usucontroller.do?acao=alterar&id=<%=u.getId_Usuario()%>"> Alterar </a> | Inativar </td>
				</tr>
			<%} %>
			</table>
		</td>
	</tr>
</table>
</body>
</html>