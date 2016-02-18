<%@page import="br.com.nettreinos.persistencia.entidade.Treino" %>
<%@page import="br.com.nettreinos.persistencia.entidade.TreinoExercicio" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Net Treinos :: Treinos modelos</title>
</head>
<body>
	<div id="paginaHome">
	<table border="0" width="980">
		<tr><td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
		</td></tr>
		<tr valign="top">
			<td width="180"><%@include file="menu.jsp" %> </td>
			<td> 
				<p><h1>Treinos </h1></p>
				<p>Nesta Página são apresentados os seus treinos <br></p>
				<p>&nbsp;</p>
				<% List<Treino> lista = (List<Treino>)request.getAttribute("lista"); %>
				<table  cellspacing="0" border="1" bordercolor="E1E1E1" >
					<tr>
						<th width="120"> Tipo </th>
						<th width="120"> Nome </th>
						<th width="200"> Descrição </th>
						<th width="120"> Ação <th>
					</tr>
					<%for(Treino t:lista){ %>
					<tr>
						<td>&nbsp;<%=t.getTipotreino().getNome() %></td>
						<td>&nbsp;<%=t.getNome() %></td>
						<td>&nbsp;<%=t.getDescr() %></td>
						<td><a href="treinoexerciciocontroller.do?acao=abrir&id_treino=<%=t.getId_Treino() %>" >Abrir</a></td>
					</tr>
					<%}%>
				</table>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>