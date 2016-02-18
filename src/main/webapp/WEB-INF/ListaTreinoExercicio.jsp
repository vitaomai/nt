<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="br.com.nettreinos.persistencia.entidade.Datatreino" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Treino" %>
<%@page import="br.com.nettreinos.persistencia.entidade.TreinoExercicio" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Net Treinos :: Treinos modelos</title>
<script type="text/javascript">

	function presenca(formulario){
		if(formulario.style.display == "none"){
			formulario.style.display = "block";
		}else{
			formulario.style.display = "none";
		}
	}
	
	function mostralistapresenca(listapresenca){
		if(listapresenca.style.display == "none"){
			listapresenca.style.display = "block";
		}else{
			listapresenca.style.display = "none";
		}
	}
	
	function editacarga(bloqueia, altera){
		if(bloqueia.style.display == "none"){
			bloqueia.style.display = "block";
		}else{
			bloqueia.style.display = "none";
		}
		
		if(altera.style.display == "none"){
			altera.style.display = "block";
		}else{
			altera.style.display = "none";
			window.alert('Alterado!')
			document.alteracarga.submit();
		}
	}
	
	function validar(){
		var qtdeErro = 0;
		var msgErro = '';
		
		if(qtdeErro>0) {
			window.alert(msgErro);
			return false;
		} else {
			window.alert('Ok!')
			document.getElementById('alteracarga').submit();
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
	/*function novaJanela (URL){
   		window.open(URL,"janela1","width=800, height=600, directories=no, location=no, menubar=no, scrollbars=no, status=no,toolbar=no, resizable=no")
	}*/
	
</script>
</head>
<body>
	<table border="0" width="980">
			<tr><td colspan="2">&nbsp;&nbsp;<img src="resources/imagens/LogoFinalok.jpg">
			</td></tr>
			<tr valign="top">
				<td width="180"><%@include file="menu.jsp" %> </td>
				<td> 
					<p><h1>Exercicios</h1>
					<p>Nesta Página são apresentados treino:  <br>
						 </p>
					<p>&nbsp;</p>
					<% List<TreinoExercicio> listate = (List<TreinoExercicio>)request.getAttribute("listate"); %>
					<table cellspacing="1" border="0" >
						<tr>
							<th> Divisão </th>
							<th> Sequência </th>
							<th> Exercicio </th>
							<th> Qtde Repetições </th>
							<th> Qtde Séries </th>
							<th> Intervalo (seg.) </th>
							<th> Descanço (seg.)</th> 
							<th> Carga </th>
						</tr>
						<%for(TreinoExercicio t:listate){ %>
						<tr align="Center">
							<td> <% out.print(t.getDivisao()); %></td>
							<td> <%=t.getNumsequencia() %></td>
							<td align="left"> <%=t.getExercicio().getNome() %>
							<td> <%=t.getQtderepetcoes()%></td>
							<td> <%=t.getQtdeseries()%></td>
							<td> <%=t.getIntervalo() %></td>
							<td> <%=t.getTempodescanco() %></td>
							<td><div id="bloqueia<%= t.getId_treinoexercicio()%>" style="display:block">
									<nobr><%=t.getCarga() %> - 
									<a href="javascript:void(0);" onclick="return editacarga(bloqueia<%= t.getId_treinoexercicio()%>, altera<%= t.getId_treinoexercicio()%>);">Editar</a>
									</nobr>
								</div>
								
								<div id="altera<%= t.getId_treinoexercicio()%>" style="display:none">
									
									<form action="treinoexerciciocontroller.do" method="post" id="alteracarga" >
									<nobr><input type="hidden" name="id_treinoexercicio" value="<%= t.getId_treinoexercicio()%>"/>
										<input type="text" name="carga" size="2" maxlength="3" value="<%=t.getCarga() %>" /> - 
										<a href="#" onclick="return editacarga(bloqueia<%= t.getId_treinoexercicio()%>, altera<%= t.getId_treinoexercicio()%>);">Salvar</a>
									</nobr>
									</form>
								
								</div>
								
							</td>
						</tr>
						<%} %>
					</table>
				</td>
			</tr>
			<tr>
				<td> 
				</td>
				<td>
					<table>
						<tr><td><p>
							
							<a href="javascript:void(0);" onclick="return presenca(formulario);">Marcar presença</a>
								<div id="formulario" style="display:none">
									<p>
									<form action="datatreinocontroller.do" method="post" name="datatreino" >
									<input type="hidden" name="id_treino" value="<%=request.getAttribute("id_treino") %>" />
									Divisão 
										<select name="divisao">
										
											<option value="A">A</option>
											<option value="B">B</option>
											<option value="C">C</option>
											<option value="D">D</option>
										
									</select>
									Data <input type="text" name="datatreino" size="8" maxlength="10"  />
									<input type="button" value="OK" onClick="validar()">
									</form>
									
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<p><a href="javascript:void(0);" onclick="return mostralistapresenca(listapresenca);">Treinos Executados</a></p>
								<div id="listapresenca" style="display:none">
									 
									<%List<Datatreino> listadt =  (List<Datatreino>)request.getAttribute("listadt");
									Calendar CalendDatanasc = Calendar.getInstance();
									SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
									
									%>
									
									<table>
										<tr><th>Data</th>
											<th>Divisão</th>
										</tr>
										<%for(Datatreino dt:listadt) {%>
										<tr>
											<td><%=sdf.format(dt.getDatatreino().getTime()) %> </td>
											<td align="center"><%=dt.getDivisao() %> </td>
										</tr>
										<%} %>
										<tr><td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table>
								
								
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>


</body>
</html>