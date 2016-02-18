
<%@page import="br.com.nettreinos.persistencia.entidade.AcademiaProf" %>
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
					<p><h1>Professores vínculados à Academia</h1></p>
					<p> Nesta Página são apresentados os professores que ministram aulas na sua academia.<br>
							 Caso deseje adicionar novos professores, efetue a busca abaixo e solicite o vínculo.</p>
					<table>	
						<tr><td>Pesquisar novo Professor:</td></tr>
						<tr><td>
							<form action="academiaprofcontroller.do" method="get">
								<input type="text" name="nome" />
								<input type="submit" name="acao" value="buscar" />
							</form>
						</td></tr>
						<tr><td></td></tr>
					</table>
					<p>&nbsp;</p>

					<% List<AcademiaProf> lista = (List<AcademiaProf>)request.getAttribute("lista"); %>
					<table cellspacing="0" border="1" bordercolor="#E1E1E1">
						<tr>
							
							<th> Nome </th>
							<th> Apelido </th>
							<th> Acao </th>
						</tr>
						<%for(AcademiaProf ap:lista){ %>
						<tr>
							<td><%=ap.getProf().getApelido() %></td>
							<td><%=ap.getProf().getNome() %></td>
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