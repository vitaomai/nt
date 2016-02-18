<%@page import="br.com.nettreinos.persistencia.entidade.Treinomodelo" %>
<%@page import="br.com.nettreinos.persistencia.entidade.TreinomodeloExercicio" %>
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
					<p><h1>Treinos Modelos</h1></p>
					<p>Nesta Página são apresentados os seus treinos modelos.<br>
						 Aqui é possível criar novo treinos e enviar os treinos aos seus atletas.</p>
					
					<p>&nbsp;</p>
					<a href="treinomodelocontroller.do?acao=novo">Criar novo</a>
					<p>&nbsp;</p>
										
					<% List<Treinomodelo> lista = (List<Treinomodelo>)request.getAttribute("lista"); %>
					<table cellspacing="0" border="1" bordercolor="#E1E1E1" >
						<tr>
							<th> Tipo </th>
							<th> Nome </th>
							<th> Descrição </th>
							<th> ação <th>
						</tr>
						<%for(Treinomodelo tm:lista){ %>
						<tr>
							<td> <%out.print(tm.getTipotreino().getNome()); %></td>
							<td> <%=tm.getNome() %> </td>
							<td> <%=tm.getDescr() %> </td>
							<td> <a href="treinomodeloexerciciocontroller.do?acao=abrir&id=<%=tm.getId_Treinomodelo() %>" >Abrir</a> | 
								<a href="treinocontroller.do?acao=enviar&id_treino=<%=tm.getId_Treinomodelo() %>">Enviar ao atleta</a> | 
								<a href="treinomodelocontroller.do?acao=alterar&id=<%=tm.getId_Treinomodelo() %>">Editar</a></td>
						</tr>
						<%} %>
					</table>
				</td>
			</tr>
		</table>
		

	</div>

</body>
</html>