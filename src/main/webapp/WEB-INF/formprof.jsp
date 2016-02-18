<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="br.com.nettreinos.persistencia.entidade.Prof" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Professores</title>
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
	
	if(document.prof.Nome.value==''){
		msgErro += 'Erro ::> NOME em branco \n';
		qtdeErro++;
	}
	if(document.prof.Sobrenome.value==''){
		msgErro += 'Erro ::> SOBRENOME em branco \n';
		qtdeErro++;
	}
	
	
	if(qtdeErro>0) {
		//document.administrador.action='administradorcontroller.do'
		window.alert(msgErro);
		return false;
	} else {
		
		window.alert('Alterado com sucesso!')
		document.prof.submit();
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
	<tr><td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
	</td></tr>
	<tr valign="top">
		<td width="180"><%@include file="menu.jsp" %> </td>
		<td> 
			<p><h1>Professor - Cadastro </h1>
			<p> Nesta Página é possível editar o seu cadastro.<br> </p>
			
			
			<% Prof prf = (Prof)request.getAttribute("prf"); 
			Calendar CalendDatanasc = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			%>
			<form action="profcontroller.do" name="prof" method="post">
			<table>
				<tr><td><input type="hidden" name="Id_prof" value="<%out.print(prf.getId_prof()); %>" />
						<input type="hidden" name="Id_usuario" value="<%=prf.getId_usuario() %>" />
						Nome 					</td><td><input type="text" name="Nome" value="<% out.print(prf.getNome()); %>" width="5" /></td>
					<td>&nbsp;Sobrenome 		</td><td><input type="text" name="Sobrenome" value="<%=prf.getSobrenome()%>" /></td></tr>
				<tr><td>Apelido 				</td><td><input type="text" name="Apelido" value="<%=prf.getApelido() %>" /></td>
					<td>&nbsp;Data Nascimento	</td><td><input type="text" name="Datanasc" value="<%=sdf.format(prf.getDatanasc().getTime())%>" onkeypress="mascara(this, '##/##/####')" maxlength="10" /></td></tr>
				<tr><td>Telefone 1 				</td><td><input type="text" name="Telefone1" value="<%=prf.getTelefone1()%>" /></td>
					<td>&nbsp;Telefone 2		</td><td><input type="text" name="Telefone2" value="<%=prf.getTelefone2()%>" /></td></tr>
				<tr><td>Número Conselho			</td><td><input type="text" name="Numconselho" value="<%=prf.getNumconselho()%>" /></td>
					<td>&nbsp;CPF 				</td><td><input type="text" name="Cpf" value="<%=prf.getCpf()%>" /></td></tr>
				<tr><td>E-mail    				</td><td><input type="text" name="Email" value="<%=prf.getEmail()%>" /></td>
					<td>&nbsp;Site   			</td><td><input type="text" name="Site" value="<%=prf.getSite()%>" /></td></tr>
				<tr><td>Facebook				</td><td><input type="text" name="Facebook" value="<%=prf.getFacebook()%>" /></td>
					<td>&nbsp;Foto	 			</td><td><input type="text" name="Foto" value="<%=prf.getFoto()%>" /></td></tr>
				<tr><td>CEP 					</td><td><input type="text" name="Cep" value="<%=prf.getCep()%>" /></td>
					<td>&nbsp;Endereco			</td><td><input type="text" name="Endereco" value="<%=prf.getEndereco()%>" /></td></tr>
				<tr><td>Número 					</td><td><input type="text" name="Numero" value="<%=prf.getNumero()%>" /></td>
					<td>&nbsp;Bairro			</td><td><input type="text" name="Bairro" value="<%=prf.getBairro()%>" /></td></tr>
				<tr><td>id Estado 				</td><td><input type="text" name="Id_estado" value="<%=prf.getId_estado()%>" readonly="readonly" /></td>
					<td>&nbsp;id Cidade			</td><td><input type="text" name="Id_cidade" value="<%=prf.getId_cidade()%>" readonly="readonly" /></td></tr>
				<tr><td></td><td><input type="hidden" name="Ativo" value="<%=prf.getAtivo()%>" /></td></tr>	
			</table>
		<p>&nbsp;</p>
		<input type="button" name="Salvar"  Value="Salvar" onClick="validar()" >
				&nbsp;&nbsp; <input type="button" name="Cancelar"  Value="Cancelar" onClick="cancelar()">
			</form>
		</td>
	</tr>
</table>					
</body>
</html>