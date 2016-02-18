<%@ page import="br.com.nettreinos.persistencia.entidade.Prof" %>
<%@ page import="java.util.List" %>
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
			<p><h1>Professores - Listagem </h1></p>
			<p>Nesta Página são apresentados todos os professores cadatrados no Sistema NetTreinos.<br> </p>
			<%List<Prof> lista = (List<Prof>)request.getAttribute("lista"); %>
				<table border="1">
					<tr>
						<th>id_prof</th>
						<th>id_usuario</th>
						<th>nome</th>
						<th>sobrenome</th>
						<th>apelido</th>
						<th>telefone1</th>
						<th>telefone2</th>
						<th>cpf</th>
						<th>foto</th>
						<th>datanasc</th>
						<th>email</th>
						<th>site</th>
						<th>facebook</th>
						<th>endereco</th>
						<th>numero</th>
						<th>cep</th>
						<th>bairro</th>
						<th>id_cidade</th>
						<th>id_estado</th>
						<th>numconselho</th>
						<th>ativo</th>
						<th>Ação</th>
					</tr>
					<%for (Prof p:lista){ %>			
					<tr>
						<td><%out.print(p.getId_prof());%></td>
						<td><%=p.getId_usuario()%></td>
						<td><%=p.getNome()%></td>
						<td><%=p.getSobrenome()%></td>
						<td><%=p.getApelido()%></td>
						<td><%=p.getTelefone1()%></td>
						<td><%=p.getTelefone2()%></td>
						<td><%=p.getCpf()%></td>
						<td><%=p.getFoto()%></td>
						<td><%=p.getDatanasc().getTime()%></td>
						<td><%=p.getEmail()%></td>
						<td><%=p.getSite()%></td>
						<td><%=p.getFacebook()%></td>
						<td><%=p.getEndereco()%></td>
						<td><%=p.getNumero()%></td>
						<td><%=p.getCep()%></td>
						<td><%=p.getBairro()%></td>
						<td><%=p.getId_cidade()%></td>
						<td><%=p.getId_estado()%></td>
						<td><%=p.getNumconselho()%></td>
						<td><%=p.getAtivo()%></td>
						<td><a href="profcontroller.do?acao=alterar&id=<%=p.getId_prof() %>">Alterar </a> Inativar</td>
					</tr>
					<%} %>
				</table>
		</td>
	</tr>
</table>
</body>
</html>