<%@page import="br.com.nettreinos.persistencia.entidade.AcademiaAtletaProf" %>
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
					<p><h1>Alunos VIPs e Professores vínculados à Academia</h1></p>
					<p> Nesta Página são apresentados os atletas que treinam com professores exclusivos na sua academia.<br>
						  </p>
						 

					<% List<AcademiaAtletaProf> lista = (List<AcademiaAtletaProf>)request.getAttribute("lista"); %>
					<table border="1" cellspacing="0" bordercolor="#E1E1E1">
						<tr align="center">
							<th> Atleta </th>
							<th> Professor </th>
							<th> Ação </th>
						</tr>
						<%for(AcademiaAtletaProf aap:lista){ %>
						<tr>
							<td><%=aap.getAtleta().getNome() %></td>
							<td><%=aap.getProf().getNome()%></td>
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