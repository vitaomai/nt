<%@page import="br.com.nettreinos.persistencia.entidade.Administrador" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NetTreinos - Administradores de Academias</title>
</head>
<body>
<table border="0" width="980">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg"></td>
	</tr>
	<tr valign="top">
		<td width="180"><%@include file="menu.jsp" %> </td>
		<td> 
			<p><h1>Atletas - Listagem</h1></p>
			<p>Nesta Página são apresentados todos os atletas cadatrados no Sistema NetTreinos.<br> </p>
			<%List<Administrador> lista = (List<Administrador>)request.getAttribute("lista");%>
		<table border="1">
			<tr>
				<th>id_admin</th>
				<th>id_academia</th>
				<th>nome</th>
				<th>sobrenome</th>
				<th>matricula</th>
				<th>ativo</th>
				<th>id_usuario</th>
				<th>Ação</th>
			</tr>
			<%for(Administrador a:lista){ %>
			<tr>
				<td><% out.print(a.getId_admin());%></td>
				<td><%= a.getId_academia() %></td>
				<td><%= a.getNome() %></td>
				<td><%= a.getSobrenome() %></td>
				<td><%= a.getMatricula() %></td>
				<td><%= a.getAtivo() %></td>
				<td><%= a.getId_usuario() %></td>
				<td><a href="administradorcontroller.do?acao=alterar&id=<%=a.getId_admin()%>">Alterar</a> Inativar</td>
			</tr>
			
			<%} %>
		</table>
		</td>
	</tr>
</table>

</body>
</html>