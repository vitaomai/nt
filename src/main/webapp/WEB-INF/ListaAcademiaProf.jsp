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
<body  bottommargin="0" leftmargin="10" topmargin="0">
	<div id="paginaHome">
		<table border="0" width="100%" cellspacing="0">
			
			<tr><td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg"></td></tr>
			<tr>
				<td width="180"><%@include file="menu.jsp" %></td>
				<td>
				
					<p><h1>Academias vínculadas ao Professor</h1></p>
					<p>Nesta Página são apresentadas as academias em que o professor ministra aula.<br>
						
					<% List<AcademiaProf> lista = (List<AcademiaProf>)request.getAttribute("lista"); %>
					<table>
						<tr>
							<th>Academia</th>
							<th>Acao</th>
						</tr>
						<%for(AcademiaProf ap:lista){ %>
						<tr>
							<td><%=ap.getAcademia().getNome() %></td>
							<td>Abrir cadastro</td>
						</tr>
						<%} %>
					</table>
				
				</td>
			</tr>
			
		
		
		</table>

</body>
</html>