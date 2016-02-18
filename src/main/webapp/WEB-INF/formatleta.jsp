<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="br.com.nettreinos.persistencia.entidade.Atleta" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function goBack() {
    window.history.back()
}
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
function cancelar() {
    window.history.back();
    return false;
}
function validar(){
	var qtdeErro = 0;
	var msgErro = '';
	
	if(document.atleta.Nome.value==''){
		msgErro += 'Erro ::> NOME em branco \n';
		qtdeErro++;
	}
	if(document.atleta.Sobrenome.value==''){
		msgErro += 'Erro ::> SOBRENOME em branco \n';
		qtdeErro++;
	}
	
	
	if(qtdeErro>0) {
		window.alert(msgErro);
		return false;
	} else {
		window.alert('Alterado com sucesso!')
		document.atleta.submit();
	}
}

function mascara(t, mask){
	 var i = t.value.length;
	 var saida = mask.substring(1,0);
	 var texto = mask.substring(i)
	 if (texto.substring(0,1) != saida){
	 t.value += texto.substring(0,1);
	 }
}
	 
</script>



<table border="0" width="980">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
		</td></tr>
	<tr valign="top">
		<td width="180"><%@include file="menu.jsp" %> </td>
		<td> 
			<p><h1>Atleta - Cadastro </h1></p>
			<p> Nesta Página é possível editar o seu cadastro.<br> </p>
			
		
			<% Atleta atl = (Atleta)request.getAttribute("atl"); 
			Calendar CalendDatanasc = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			%>
			<form action="atletacontroller.do" name="atleta" method="post">
				<table>
					<tr><td><input type="hidden"  name="id_atleta" value="<% out.print(atl.getId_atleta());%>" />
							<input type="hidden" name="id_usuario" value="<%=atl.getId_usuario() %>" />  </td></tr>
					
					<tr><td>Nome		</td><td>	<input type="text" name="Nome" value="<%=atl.getNome()%>"/>
						<td>&nbsp;Sobrenome	</td><td>	<input type="text" name="Sobrenome" value="<%=atl.getSobrenome()%>"/></td></tr>
					<tr><td>Apelido		</td><td>	<input type="text" name="Apelido" value="<%=atl.getApelido()%>"/></td>
						<td>&nbsp;DataNasc	</td><td>	<input type="text" name="DataNasc" value="<%=sdf.format(atl.getDatanasc().getTime())%>" onkeypress="mascara(this, '##/##/####')" maxlength="10"/>
						</td></tr>					
					<tr><td>Telefone1	</td><td>	<input type="text" name="Telefone1" value="<%=atl.getTelefone1()%>" /></td>
						<td>&nbsp;Telefone2	</td><td>	<input type="text" name="Telefone2" value="<%=atl.getTelefone2()%>"/></td></tr>
					<tr><td>CPF			</td><td>	<input type="text" name="Cpf" value="<%=atl.getCpf()%>"/></td>
						<td>&nbsp;Foto		</td><td>	<input type="text" name="Foto" value="<%=atl.getFoto()%>"/></td></tr>
					<tr><td>Email		</td><td>	<input type="text" name="Email" value="<%=atl.getEmail()%>"/></td>
						<td>&nbsp;Facebook	</td><td>	<input type="text" name="Facebook" value="<%=atl.getFacebook()%>"/></td></tr>
					<tr><td>Endereco	</td><td>	<input type="text" name="Endereco" value="<%=atl.getEndereco()%>"/></td>
						<td>&nbsp;Numero		</td><td>	<input type="text" name="Numero" value="<%=atl.getNumero()%>"/></td></tr>
					<tr><td>Bairro		</td><td>	<input type="text" name="Bairro" value="<%=atl.getBairro()%>"/></td>
						<td>&nbsp;Cep			</td><td>	<input type="text" name="Cep" value="<%=atl.getCep()%>"/></td></tr>
					<tr><td><input type="hidden" name="id_cidade" value="<%=atl.getId_cidade()%>"/></td>
						<td><input type="hidden" name="id_estado" value="<%=atl.getId_estado()%>"/></td></tr>
				</table>
					&nbsp;<br>
					<input type="button" name="Salvar"  Value="Salvar" onClick="validar()" >
					&nbsp;&nbsp; <input type="button" name="Cancelar"  Value="Cancelar" onClick="cancelar()">
			</form>
		</td>
	</tr>
</table>

</body>
</html>