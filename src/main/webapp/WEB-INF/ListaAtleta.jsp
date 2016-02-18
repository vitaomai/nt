<%@page import="br.com.nettreinos.persistencia.entidade.Atleta" %>
<%@page import="java.util.List" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<table border="0" width="980">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg"></td>
	</tr>
	<tr valign="top">
		<td width="180"><%@include file="menu.jsp" %> </td>
		<td> 
			<p><h1>Atletas - Listagem</h1></p>
			<p>Nesta Página são apresentados todos os atletas cadatrados no Sistema NetTreinos.<br> </p>
			<%List<Atleta> lista = (List<Atleta>)request.getAttribute("lista");%>
			<table border="1" cellspacing="0">
				<tr>
					<th>id_atleta</th>
					<th>id_usuari</th>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>Apelido</th>
					<th>Ativo</th>
					<th>Telefone1</th>
					<th>Telefone2</th>
					<th>CPF</th>
					<th>Foto</th>
					<th>DataNasc</th>
					<th>Email</th>
					<th>Facebook</th>
					<th>Endereco</th>
					<th>Cep</th>
					<th>Bairro</th>
					<th>Numero</th>
					<th>id_Cidade</th>
					<th>id_Estado</th>
					<th>Ação</th>
				</tr>
			<%for(Atleta a:lista){%>
				<tr>
					<td><% out.print(a.getId_atleta());%></td>
					<td><%=a.getId_usuario()%></td>
					<td><%=a.getNome()%></td>
					<td><%=a.getSobrenome()%></td>
					<td><%=a.getApelido()%></td>
					<td><%=a.getAtivo()%></td>
					<td><%=a.getTelefone1()%></td>
					<td><%=a.getTelefone2()%></td>
					<td><%=a.getCpf()%></td>
					<td><%=a.getFoto()%></td>
					<td><%=a.getDatanasc().getTime()%></td>
					<td><%=a.getEmail()%></td>
					<td><%=a.getFacebook()%></td>
					<td><%=a.getEndereco()%></td>
					<td><%=a.getCep()%></td>
					<td><%=a.getBairro()%></td>
					<td><%=a.getNumero()%></td>
					<td><%=a.getId_cidade()%></td>
					<td><%=a.getId_estado()%></td>
					<td><a href="atletacontroller.do?acao=alterar&id=<%=a.getId_atleta()%>">Alterar</a> | Inativar </td>
				</tr>
			<%}%>
			</table>
		</td>
	</tr>
</table>
</body>
</html>