<%@page import="br.com.nettreinos.persistencia.entidade.Usuario" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Menu" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Administrador" %>
<%@page import="br.com.nettreinos.persistencia.entidade.Academia" %>
<%@page import="br.com.nettreinos.persistencia.jdbc.MenuDAO" %>
<%@page import="br.com.nettreinos.persistencia.jdbc.AcademiaDAO" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
		<% Usuario usuMenu = (Usuario)request.getSession().getAttribute("usuOK"); %>
		
		<br>Usuário: <%=usuMenu.getLogin()%>
		
		<% Integer id_tipouser = usuMenu.getId_TipoUsuario();
		
		if (id_tipouser==3){
			Administrador adm = (Administrador)request.getSession().getAttribute("admOK");
			//Academia acad = new Academia();
			AcademiaDAO acadDAO = new AcademiaDAO();
			Academia acad = acadDAO.buscarPorId(adm.getId_academia()); %>
			<br>Academia: <%=acad.getNome()%>
			
		<% }
		
		MenuDAO MenDAO = new MenuDAO();
	
		List<Menu> listamenu = MenDAO.buscarMenu(id_tipouser);
		%>
		<br> &nbsp; <br>
		
		<table>
			<%
			for(Menu m:listamenu){%>
				<tr>
					<td><a href="<% out.print(m.getLink()); %>"> <%=m.getItem()%> </a></td>
				</tr>
			<%} %>
			
		</table>
		
		<a href="loginController.do">Sair</a> 
	
