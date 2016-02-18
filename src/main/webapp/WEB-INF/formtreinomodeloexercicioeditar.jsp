<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.com.nettreinos.persistencia.entidade.Academia" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Usuario" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Prof" %>
<%@page import="br.com.nettreinos.persistencia.entidade.TreinomodeloExercicio" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Treinomodelo" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Exercicio" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	
	
	
	if(qtdeErro>0) {
		window.alert(msgErro);
		return false;
	} else {
		window.alert('Novo Treino Modelo inserido com sucesso!')
		document.treinomodeloexercicio.submit();
	}
}


</script>



	<table border="0" width="100%">
		<tr><td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
		</td></tr>
		<tr valign="top">
			<td width="180"><%@include file="menu.jsp" %> </td>
			<td> 
				<p><h1>Professor - Edição de Treino modelo </h1></p>
				<p> Nesta Página é possível editar os exercicios de treino modelo.<br> </p>
				<% Treinomodelo tremod =  (Treinomodelo)request.getAttribute("tremod"); %>
				<% List<TreinomodeloExercicio> listatme = (List<TreinomodeloExercicio>)request.getAttribute("listatme"); %>
				<% TreinomodeloExercicio tremodexe = (TreinomodeloExercicio)request.getAttribute("tremodexe"); %>
				
				
					<table>
						<tr><td>Treino: <% out.print(tremod.getNome()); %></td>
						 
					</table>
					<table border="0">
						<tr>
							<th>Divisão</th>
							<th>Sequencia</th>
							<th>Nome</th>
							<th>Qtde Repetições</th>
							<th>Qtde Séries</th>							
							<th>Intervalo (seg)</th>							
							<th>Descanço</th>
							<th>Carga</th>
							<th>Inserir</th>
						</tr>
						<%for(TreinomodeloExercicio tme:listatme){ %>
						<tr>
							<td><%= tme.getDivisao()%></td>
							<td><%= tme.getNumsequencia()%></td>
							<td><%= tme.getExercicio().getNome()%></td>
							<td><%= tme.getQtderepetcoes()%></td>
							<td><%= tme.getQtdeseries()%></td>
							<td><%= tme.getIntervalo()%></td>
							<td><%= tme.getTempodescanco()%></td>
							<td><%= tme.getCarga()%></td>
							<td></td>
						</tr>
						<%} %>
					<tr>
						<% List<Exercicio> listaexe = (List<Exercicio>)request.getAttribute("listaexe");  %>
						<form action="treinomodeloexerciciocontroller.do" name="treinomodeloexercicio" method="post">
							<td><input type="hidden" name="id_treinomodeloexercicio" size="1" value="<%= tremodexe.getId_TreinomodeloExercicio() %>">
								<input type="hidden" name="id_treinomodelo" size="1" value="<%= tremod.getId_Treinomodelo() %>">
								<input type="text" name="divisao" value="<%= tremodexe.getDivisao() %>" size="2"></td>
							<td><input type="text" name="sequencia" value="<%= tremodexe.getNumsequencia() %>" size="2"></td>
							<td><select name="id_Exercicio">
									<option value="<%= tremodexe.getExercicio().getId_Exercicio() %>"><%= tremodexe.getExercicio().getNome() %></option>
									<% for(Exercicio e:listaexe){%>
									<option value="<%= e.getId_Exercicio()%>"><%= e.getNome()%></option>
									<%} %>
								</select></td>
							<td><input type="text" name="qtderepeticoes" value="<%= tremodexe.getQtderepetcoes() %>" size="2"></td>
							<td><input type="text" name="qtdeseries" value="<%= tremodexe.getQtdeseries() %>" size="2"></td>
							<td><input type="text" name="intervalo" value="<%= tremodexe.getIntervalo() %>" size="2"></td>
							<td><input type="text" name="tempodescanco" value="<%= tremodexe.getTempodescanco() %>" size="2"></td>
							<td><input type="text" name="carga" value="<%= tremodexe.getCarga() %>" size="2"></td>
							<td><input type="hidden" name="enviar" value="alterar">
								<nobr><input type="button" name="Ok"  Value="Alterar" onClick="validar()" >
								&nbsp; <input type="button" name="Voltar"  Value="Cancelar" onClick="cancelar()"></nobr>
							</td>
						</form>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	
	
	

</body>
</html>