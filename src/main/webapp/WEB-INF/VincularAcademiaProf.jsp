<%@page import="br.com.nettreinos.persistencia.entidade.Prof" %>
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

<table border="0" width="980">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg"></td>
	</tr>
	<tr valign="top">
		<td width="180"><%@include file="menu.jsp" %> </td>
		<td>  
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
		<p>&nbsp;	</p>
		<%List<Prof> lista = (List<Prof>)request.getAttribute("lista"); %>
			<table border="1">	
				<tr>
					<th>id_atleta</th>
					<th>Nome</th>		
					<th>Sobrenome</th>
					<th>Ação</th>
				</tr>
		
				<%for(Prof p:lista){%>
				<tr>
					<td><% out.print(p.getId_prof());%></td>
					<td><%=p.getNome()%></td>
					<td><%=p.getApelido()%></td>
					<td><a href="academiaprofcontroller.do?acao=vincular&id_prof=<%=p.getId_prof()%>">Vincular</a></td>
				</tr>
				<%}%>
			</table>
		</td>
	</tr>
</table>	
</body>
</html>