<%@page import="br.com.nettreinos.persistencia.entidade.Atleta" %>
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
				<tr><td>Pesquisar novo atleta:</td></tr>
				<tr><td>
					<form action="atletaprofcontroller.do" method="get" >
						<input type="text" name="nome" />
						<input type="submit" name="acao" value="buscar" />
					</form>
				</td></tr>
				<tr><td></td></tr>
			</table>
			<p>&nbsp;</p>
				
			<%List<Atleta> lista = (List<Atleta>)request.getAttribute("lista");%>
			<table>	
				<tr>
					<th>id_atleta</th>
					<th>Nome</th>		
					<th>Sobrenome</th>
					<th>A��o</th>
				</tr>
		
			<%for(Atleta a:lista){%>
				<tr>
					<td><% out.print(a.getId_atleta());%></td>
					<td><%=a.getNome()%></td>
					<td><%=a.getSobrenome()%></td>
					<td><a href="atletaprofcontroller.do?acao=vincular&id_atleta=<%=a.getId_atleta()%>">Vincular</a></td>
				</tr>
			<%}%>
		

			</table>
		</td>
	</tr>
</table>

</body>
</html>