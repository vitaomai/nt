package br.com.nettreinos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import br.com.nettreinos.persistencia.entidade.AcademiaAtleta;
import br.com.nettreinos.persistencia.entidade.Administrador;
import br.com.nettreinos.persistencia.entidade.AcademiaAtletaProf;
import br.com.nettreinos.persistencia.jdbc.AcademiaAtletaProfDAO;


@SuppressWarnings("serial")
@WebServlet("/academiaatletaprofcontroller.do")
public class AcademiaAtletaProfController extends HttpServlet  {
	
	public AcademiaAtletaProfController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		AcademiaAtletaProfDAO acadatlprfDAO = new AcademiaAtletaProfDAO ();
		String acao = req.getParameter("acao");
		
		
		if(acao.equals("listar")){
			Administrador admTeste = (Administrador)req.getSession().getAttribute("admOK");
			
			List<AcademiaAtletaProf> lista = acadatlprfDAO.buscarAcadAtlPrf_idadm(admTeste.getId_academia());
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaAcademiaAtletaProf.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}
	
}
