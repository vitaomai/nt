
<%@page import="br.com.nettreinos.persistencia.entidade.AcademiaAtleta" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="paginaHome">
		<table border="0" width="980">
			<tr><td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
			</td></tr>
			<tr valign="top">
				<td width="180"><%@include file="menu.jsp" %> </td>
				<td> 
					<p><h1>Alunos vínculados à Academia</h1></p>
					<p> Nesta Página são apresentados os atletas que treinam na sua academia.<br>
						 Caso deseje adicionar novos atletas, efetue a busca abaixo e solicite o vínculo.</p>
						 
					<table>	
						<tr><td>Pesquisar novo atleta:</td></tr>
						<tr><td>
							<form  action="academiaatletacontroller.do" method="get" >
								<input type="text" name="nome" />
								<input type="submit" name="acao" value="buscar" />
							</form>
						</td></tr>

					</table>
					<p>&nbsp;</p>
					<% List<AcademiaAtleta> lista = (List<AcademiaAtleta>)request.getAttribute("lista"); %>
					<table border="1" cellspacing="0" bordercolor="#E1E1E1">
						<tr align="center">
							<th> Nome Atleta </th>
							<th> Apelido Atleta </th>
							<th> Acao </th>
						</tr>
						<%for(AcademiaAtleta aa:lista){ %>
						<tr>
							<td><%=aa.getAtleta().getNome() %></td>
							<td><%=aa.getAtleta().getApelido() %></td>
							<td>Abrir cadastro</td>
						</tr>
						<%} %>
					</table>
								
		
	
			</td>
			</tr>
		</table>
		</div>
</body>
</html>