<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="br.com.nettreinos.persistencia.entidade.Academia" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NetTreinos - Academias</title>
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
	
	if(document.academia.Nome.value==''){
		msgErro += 'Erro ::> NOME em branco \n';
		qtdeErro++;
	}
	if(document.academia.Razaosocial.value==''){
		msgErro += 'Erro ::> RAZAO SOCIAL em branco \n';
		qtdeErro++;
	}
	
	if(qtdeErro>0) {
		window.alert(msgErro);
		return false;
	} else {
		window.alert('Alterado com sucesso!')
		document.academia.submit();
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
					<p><h1>Academia - Cadastro </h1></p>
					<p> Nesta Página é possível editar o cadastro da academia.<br> </p>
					
					<% Academia acad = (Academia)request.getAttribute("acad"); 
					Calendar CalendDatanasc = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					%>
					<form action="academiacontroller.do" name="academia" method="post">
						<table>
							<tr><td><input type="hidden" name="id_academia" value="<% out.print(acad.getId_Academia()); %>" />
									Nome 		</td><td><input type="text" name="Nome" value="<%= acad.getNome() %>" /></td>
								<td>&nbsp;RazaoSocial </td><td><input type="text" name="Razaosocial" value="<%= acad.getRazaoSocial()%>" /></td></tr>
							<tr><td>Telefone1  	</td><td><input type="text" name="Telefone1" value="<%= acad.getTelefone1()%>" /></td>
								<td>&nbsp;Telefone2  	</td><td><input type="text" name="Telefone2" value="<%= acad.getTelefone2()%>" /></td></tr>
							<tr><td>CNPJ:		</td><td><input type="text" name="CNPJ" value="<%= acad.getCNPJ()%>" /></td>
								<td>&nbsp;Datacad 	</td><td><input type="text" name="Datacad" value="<%=sdf.format(acad.getDataCad().getTime())%>" onkeypress="mascara(this, '##/##/####')" maxlength="10"/></td></tr>
							<tr><td>Responsavel	</td><td><input type="text" name="Responsavel" value="<%= acad.getResponsavel()%>" /></td>
								<td>&nbsp;Email		</td><td><input type="text" name="Email" value="<%= acad.getEmail()%>" /></td></tr>
							<tr><td>Site		</td><td><input type="text" name="Site" value="<%= acad.getSite()%>" /></td>
								<td>&nbsp;Facebook	</td><td><input type="text" name="Facebook" value="<%=acad.getFacebook()%>" /></td></tr>
							<tr><td>Endereco	</td><td><input type="text" name="Endereco" value="<%=acad.getEndereco()%>" /></td>
								<td>&nbsp;Numero		</td><td><input type="text" name="Numero" value="<%= acad.getNumero()%>" /></td></tr>
							<tr><td>Bairro		</td><td><input type="text" name="Bairro" value="<%= acad.getBairro()%>" /></td>
								<td>&nbsp;Cep			</td><td><input type="text" name="Cep" value="<%= acad.getCep()%>" /></td></tr>
							
							<tr><td><input type="hidden" name="Id_cidade" value="<%= acad.getId_Cidade()%>" /></td>
								<td><input type="hidden" name="Id_estado" value="<%= acad.getId_Estado()%>" /></td>
								<td> </td>
								<td><input type="hidden" name="Ativo" value="<%= acad.isAtivo()%>" /></td></tr>
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