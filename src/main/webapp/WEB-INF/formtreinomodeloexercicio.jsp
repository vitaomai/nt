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
<script type="text/javascript">
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



	<table border="0" width="980">
		<tr><td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
		</td></tr>
		<tr valign="top">
			<td width="180"><%@include file="menu.jsp" %> </td>
			<td> 
				<p><h1>Professor - Edição de Treino modelo </h1></p>
				<p> Nesta Página é possível editar os exercicios de treino modelo.<br> </p>
				<% Treinomodelo tremod =  (Treinomodelo)request.getAttribute("tremod"); %>
				<% List<TreinomodeloExercicio> listatme = (List<TreinomodeloExercicio>)request.getAttribute("listatme"); %>
				
				
					<table>
						<tr><td>Treino: <% out.print(tremod.getNome()); %></td>
						 
					</table>
					<table   cellspacing="0" border="1" bordercolor="#E1E1E1">
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
							<td><input type="hidden" name="id_treinomodelo" size="1" value="<%= tremod.getId_Treinomodelo() %>">
								<%= tme.getDivisao()%></td>
							<td><%= tme.getNumsequencia()%></td>
							<td><%= tme.getExercicio().getNome()%></td>
							<td><%= tme.getQtderepetcoes()%></td>
							<td><%= tme.getQtdeseries()%></td>
							<td><%= tme.getIntervalo()%></td>
							<td><%= tme.getTempodescanco()%></td>
							<td><%= tme.getCarga()%></td>
							<td><a href="treinomodeloexerciciocontroller.do?acao=remover&id_treino=<%= tremod.getId_Treinomodelo() %>&id_exercicio=<%= tme.getId_TreinomodeloExercicio() %>">Remover</a>
								<a href="treinomodeloexerciciocontroller.do?acao=editar&id_treino=<%= tremod.getId_Treinomodelo() %>&id_exercicio=<%= tme.getId_TreinomodeloExercicio() %>">Editar</a>
								</td>
						</tr></form>
						<%} %>
					<tr>
						<% List<Exercicio> listaexe = (List<Exercicio>)request.getAttribute("listaexe");  %>
						<form action="treinomodeloexerciciocontroller.do" name="treinomodeloexercicio" method="post">
							<td><input type="hidden" name="id_treinomodelo" size="1" value="<%= tremod.getId_Treinomodelo() %>">
								<input type="text" name="divisao" size="2"></td>
							<td><input type="text" name="sequencia"  size="2"></td>
							<td><select name="id_Exercicio">
									<% for(Exercicio e:listaexe){%>
									<option value="<%= e.getId_Exercicio()%>"><%= e.getNome()%></option>
									<%} %>
								</select>
							</td>
							<td><input type="text" name="qtderepeticoes"  size="2"></td>
							<td><input type="text" name="qtdeseries" size="2"></td>
							<td><input type="text" name="intervalo" size="2"></td>
							<td><input type="text" name="tempodescanco" size="2"></td>
							<td><input type="text" name="carga" size="2"></td>
							<td><input type="hidden" name="enviar" value="inserir">
								<input type="button" name="Inserir"  value="Inserir" onClick="validar()" >
								
							</td>
						</form>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	
	
	

</body>
</html>