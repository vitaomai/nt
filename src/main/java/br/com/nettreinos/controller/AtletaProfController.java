package br.com.nettreinos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nettreinos.persistencia.entidade.Atleta;
import br.com.nettreinos.persistencia.entidade.AtletaProf;
import br.com.nettreinos.persistencia.entidade.Prof;
import br.com.nettreinos.persistencia.jdbc.AtletaDAO;
import br.com.nettreinos.persistencia.jdbc.AtletaProfDAO;



@SuppressWarnings("serial")
@WebServlet("/atletaprofcontroller.do")

public class AtletaProfController extends HttpServlet  {
	public AtletaProfController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		AtletaProfDAO atlprfDAO = new AtletaProfDAO();
		AtletaDAO atlDAO = new AtletaDAO();
		
		String acao = req.getParameter("acao");
		//String id_uprof = req.getParameter("id_uprof");
		Prof prf = (Prof)req.getSession().getAttribute("prfOK");
		
		
		if(acao.equals("listar")){ //lista todos os atletas que o professor possui
			List<AtletaProf> lista = atlprfDAO.buscarAtleProf_idprf(prf.getId_prof());
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaAtletaProf.jsp");
			dispatcher.forward(req, resp);
		} else if(acao.equals("buscar")){ //busca novos atletas dentre os cadastrados no sistemas NetTreinos
			List<Atleta> lista = atlprfDAO.buscarPorNome(req.getParameter("nome"));
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/VincularAtletaProf.jsp");
			dispatcher.forward(req, resp);
		} else if(acao.equals("vincular")){ // vincula o atleta ao professor logado
			Atleta atl = atlDAO.buscarPorId(Integer.parseInt(req.getParameter("id_atleta")));
			
			AtletaProf atlprf = new AtletaProf();
			atlprf.setAtleta(atl);
			atlprf.setProf(prf);
			
			
			atlprfDAO.inserir(atlprf);
			
			List<AtletaProf> lista = atlprfDAO.buscarAtleProf_idprf(prf.getId_prof());
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaAtletaProf.jsp");
			dispatcher.forward(req, resp);

					
		}
		
		/*else if(acao.equals("buscar")){
			List<AtletaProf> lista = atlprfDAO.buscarAtleProf_idprf(prf.getId_prof());
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaAtletaProf.jsp");
			dispatcher.forward(req, resp);
			
		}*/
		
		
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}
}
