<%@page import="br.com.nettreinos.persistencia.entidade.AtletaProf" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Net Treinos :: Vínculo Atleta - Professor</title>
</head>
<body>
	<div id="paginaHome">
	
	
	<table border="0" width="980">
			<tr><td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
			</td></tr>
			<tr valign="top">
				<td width="180"><%@include file="menu.jsp" %> </td>
				<td> 
					<p><h1>Alunos vínculados ao Professor</h1></p>
					<p>Nesta Página são apresentados os atletas que treinam com você.<br>
						 Caso deseje adicionar novos atletas, efetue a busca abaixo e solicite o vínculo.</p>
					<table>	
						<tr><td>Pesquisar novo Aluno:</td></tr>
						<tr><td>
							<form action="atletaprofcontroller.do" method="get" >
								<input type="text" name="nome" size="10"/>
								<input type="submit" name="acao" value="buscar" />
							</form>
						</td></tr>
						<tr><td> </td></tr>
					</table>
					<p>&nbsp;</p>
					<% List<AtletaProf> lista = (List<AtletaProf>)request.getAttribute("lista"); %>
					<table cellspacing="0" border="1" bordercolor="#E1E1E1" >
						<tr>

							<th> Aluno </th>
							<th> Acao </th>
						</tr>
						<%for(AtletaProf ap:lista){ %>
						<tr>
							<td>&nbsp;<%=ap.getAtleta().getNome() %>&nbsp;</td>
							<td>&nbsp; Abrir cadastro</td>
						</tr>
						<%} %>
					</table>
				</td>
			</tr>
		</table>
		

	</div>
</body>
</html>