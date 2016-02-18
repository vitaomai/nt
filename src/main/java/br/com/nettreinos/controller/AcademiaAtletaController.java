package br.com.nettreinos.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nettreinos.persistencia.entidade.Academia;
import br.com.nettreinos.persistencia.entidade.AcademiaAtleta;
import br.com.nettreinos.persistencia.entidade.Administrador;
import br.com.nettreinos.persistencia.entidade.Atleta;
import br.com.nettreinos.persistencia.jdbc.AcademiaAtletaDAO;
import br.com.nettreinos.persistencia.jdbc.AcademiaDAO;
import br.com.nettreinos.persistencia.jdbc.AtletaDAO;

@SuppressWarnings("serial")
@WebServlet("/academiaatletacontroller.do")
public class AcademiaAtletaController extends HttpServlet {

	public AcademiaAtletaController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		AcademiaAtletaDAO acadatlDAO = new AcademiaAtletaDAO();
		AtletaDAO atlDAO = new AtletaDAO();
		AcademiaDAO acadDAO = new AcademiaDAO();
		
		String acao = req.getParameter("acao");
		//String id_uacad = req.getParameter("id_uadm");
		Administrador adm = (Administrador) req.getSession().getAttribute("admOK");

		if(acao.equals("listar")){
			List<AcademiaAtleta> lista = acadatlDAO.buscarAcadAtl_iduadm(adm.getId_academia());
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaAcademiaAtleta.jsp");
			dispatcher.forward(req, resp);
		}else if(acao.equals("buscar")){
			List<Atleta> lista = acadatlDAO.buscarPorNome(req.getParameter("nome"));
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/VincularAcademiaAtleta.jsp");
			dispatcher.forward(req, resp);
		} else if(acao.equals("vincular")){
			Academia acad = acadDAO.buscarPorId(adm.getId_academia());
			Atleta atl = atlDAO.buscarPorId(Integer.parseInt(req.getParameter("id_atleta")));

			
			AcademiaAtleta acadatl = new AcademiaAtleta();
			acadatl.setAcademia(acad);
			acadatl.setAtleta(atl);
			
			acadatlDAO.inserir(acadatl); // vincular o atleta à academia
			
			List<AcademiaAtleta> lista = acadatlDAO.buscarAcadAtl_iduadm(adm.getId_academia());
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaAcademiaAtleta.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}
	
	
}
