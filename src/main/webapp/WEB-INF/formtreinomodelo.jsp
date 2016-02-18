
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.com.nettreinos.persistencia.entidade.Academia" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Usuario" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Prof" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Treinomodelo" %>
<%@page import="br.com.nettreinos.persistencia.entidade.TipoTreino"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo treino modelo</title>
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
	
	if(document.treinomodelo.tipotreino.value==''){
		msgErro += 'Erro ::> TIPO TREINO em branco \n';
		qtdeErro++;
	}
	if(document.treinomodelo.nome.value==''){
		msgErro += 'Erro ::> NOME em branco \n';
		qtdeErro++;
	}
	
	if(qtdeErro>0) {
		window.alert(msgErro);
		return false;
	} else {
		window.alert('Novo Treino Modelo inserido com sucesso!')
		document.treinomodelo.submit();
	}
}

</script>

	<table  width="980"  cellspacing="0" border="1" bordercolor="#E1E1E1">
		<tr><td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
		</td></tr>
		<tr valign="top">
			<td width="180"><%@include file="menu.jsp" %> </td>
			<td> 
				<p><h1>Professor - Novo treino modelo </h1></p>
				<p> Nesta Página é possível editar os exercicios  do seu treino modelo.<br> </p>
				<% Treinomodelo tremod = (Treinomodelo)request.getAttribute("tremod"); %>
				<% List<TipoTreino> listatt = (List<TipoTreino>)request.getAttribute("listatt"); %>
				<form action="treinomodelocontroller.do" name="treinomodelo" method="post">
					<table >
						<tr><td>&nbsp;</td><td><input type="hidden" name="id_treinomodelo" value="<% out.print(tremod.getId_Treinomodelo()); %>"/> </td></tr>
						<tr><td>Tipo: 	</td><td>
							<select name="tipotreino">
									<option value="<%=tremod.getTipotreino().getId_Tipotreino() %>"><%=tremod.getTipotreino().getNome() %></option>
								<% for(TipoTreino tt:listatt){ %>
									<option value="<%= tt.getId_Tipotreino() %>"><%= tt.getNome() %> </option>
								<% }%>
							</select>
						
						</td></tr>
						<tr><td>Nome: 	</td><td><input type="text" name="nome" value="<%=tremod.getNome() %>" /></td></tr>
						<tr><td>Descrição: 	</td><td><input type="text" name="descr"  value="<%=tremod.getDescr() %>" /></td></tr>
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