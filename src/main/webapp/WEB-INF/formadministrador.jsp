<%@page import="br.com.nettreinos.persistencia.entidade.Administrador" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>>NetTreinos - Administradores</title>
</head>
<body>


<script>
function cancelar() {
    window.history.back();
    return false;
}
function validar(){
	var qtdeErro = 0;
	var msgErro = '';
	
	if(document.administrador.Nome.value==''){
		msgErro += 'Erro ::> NOME em branco \n';
		qtdeErro++;
	}
	if(document.administrador.Sobrenome.value==''){
		msgErro += 'Erro ::> SOBRENOME em branco \n';
		qtdeErro++;
	}
	
	
	if(qtdeErro>0) {
		//document.administrador.action='administradorcontroller.do'
		window.alert(msgErro);
		return false;
	} else {
		
		window.alert('Alterado com sucesso!')
		document.administrador.submit();
	}

}

</script>

<table border="0" width="980">
			<tr><td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
			</td></tr>
			<tr valign="top">
				<td width="180"><%@include file="menu.jsp" %> </td>
				<td> 
					<p><h1>Administrador - Cadastro </h1></p>
					<p> Nesta Página é possível editar o seu cadastro.<br> </p>
					

					<% Administrador adm = (Administrador)request.getAttribute("adm"); %>
					<form action="administradorcontroller.do" name="administrador"  method="post"> 
						<table>
							<tr><td><input type="hidden" name="Id_admin" value="<% out.print(adm.getId_admin()); %>" />
									<input type="hidden" name="Id_academia" value="<%= adm.getId_academia() %>" />
									Nome 		</td><td><input type="text" name="Nome" value="<%= adm.getNome() %>" /> </td></tr>
							<tr><td>Sobrenome 	</td><td><input type="text" name="Sobrenome" value="<%= adm.getSobrenome() %>" /> </td></tr>
							<tr><td>Matricula	</td><td><input type="text" name="Matricula" value="<%= adm.getMatricula() %>" /> </td></tr>
							<tr><td><input type="hidden" name="Ativo" value="<%= adm.getAtivo() %>" /> 
									<input type="hidden" name="Id_usuario" value="<%= adm.getId_usuario() %>" /> </td></tr>
						</table>	
						
						<input type="button" name="Salvar"  Value="Salvar" onClick="validar()" >
						&nbsp;&nbsp; <input type="button" name="Cancelar"  Value="Cancelar" onClick="cancelar()">
					</form>
				</td>
			</tr>
		</table>
</body>
</body>
</body>
</html>