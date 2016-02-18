<%@page import="br.com.nettreinos.persistencia.entidade.Academia" %>
<%@page import="java.util.List" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>

<table border="0" width="980">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg"></td>
	</tr>
	<tr valign="top">
		<td width="180"><%@include file="menu.jsp" %> </td>
		<td> 
			<%List<Academia> lista = (List<Academia>)request.getAttribute("lista"); %>
			<table border="1">
				<tr>
					<th>Id_Academia</th>
					<th>Nome</th>
					<th>RazaoSocial</th>
					<th>Telefone1</th>
					<th>Telefone2</th>
					<th>CNPJ</th>
					<th>DateDatacad</th>
					<th>Responsavel</th>
					<th>Email</th>
					<th>Site</th>
					<th>Facebook</th>
					<th>Endereco</th>
					<th>Cep</th>
					<th>Bairro</th>
					<th>Numero</th>
					<th>Id_Cidade</th>
					<th>Id_Estado</th>
					<th>Ativo</th>
					<th>Ação</th>
				</tr>
				<%for (Academia a:lista){ %>
				<tr>
					<td><% out.print(a.getId_Academia());%></td>
					<td><%=a.getNome()%></td>
					<td><%=a.getRazaoSocial()%></td>
					<td><%=a.getTelefone1()%></td>
					<td><%=a.getTelefone2()%></td>
					<td><%=a.getCNPJ()%></td>
					<td><%=a.getDataCad().getTime()%></td>
					<td><%=a.getResponsavel()%></td>
					<td><%=a.getEmail()%></td>
					<td><%=a.getSite()%></td>
					<td><%=a.getFacebook()%></td>
					<td><%=a.getEndereco()%></td>
					<td><%=a.getCep()%></td>
					<td><%=a.getBairro()%></td>
					<td><%=a.getNumero()%></td>
					<td><%=a.getId_Cidade()%></td>
					<td><%=a.getId_Estado()%></td>
					<td><%=a.isAtivo()%></td>
					<td> <a href="academiacontroller.do?acao=alterar&id=<%=a.getId_Academia() %>">Alterar</a> | Inativar </td>
				</tr>
			<%}%>
			</table>
		</td>
	</tr>
</table>
	
</body>
</html>