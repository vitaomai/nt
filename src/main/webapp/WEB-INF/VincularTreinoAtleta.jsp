<%@page import="br.com.nettreinos.persistencia.entidade.Treinomodelo" %>
<%@page import="br.com.nettreinos.persistencia.entidade.AtletaProf" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enviar treino ao Atleta</title>
</head>
<body>
	
	<table border="0" width="980">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg"></td>
	</tr>
	<tr valign="top">
		<td width="180"><%@include file="menu.jsp" %> </td>
		<td> 
				<p><h1>Alunos vínculados ao Professor</h1></p>
					<% Treinomodelo tremod = (Treinomodelo)request.getAttribute("tremod"); %>

					<p>Nesta Página são apresentados os atletas que treinam com você.<br>
						 Ao clicar em "Enviar" o treino "<b><%= tremod.getNome() %></b>" será enviado ao atleta.</p>

					<% List<AtletaProf> lista = (List<AtletaProf>)request.getAttribute("lista"); %>
					<table cellspacing="2" border="0" >
						<tr>
							<th> Atleta </th>
							<th> Acao </th>
						</tr>
						<%for(AtletaProf ap:lista){ %>
						<tr>
							<td> <%=ap.getAtleta().getNome() %> </td>
							<td> <a href="treinocontroller.do?acao=vincular&id_treinomodelo=<%=tremod.getId_Treinomodelo()%>&id_atleta=<%=ap.getAtleta().getId_atleta()%>">Enviar</a> </td>
						</tr>
						<%} %>
					</table>

		</td>
	</tr>
</table>
	
</body>
</html>