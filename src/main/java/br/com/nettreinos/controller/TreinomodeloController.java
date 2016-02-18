package br.com.nettreinos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nettreinos.persistencia.entidade.Prof;
import br.com.nettreinos.persistencia.jdbc.TipoTreinoDAO;
import br.com.nettreinos.persistencia.entidade.Treinomodelo;
import br.com.nettreinos.persistencia.jdbc.TreinomodeloDAO;

import br.com.nettreinos.persistencia.entidade.TipoTreino;

@SuppressWarnings("serial")
@WebServlet("/treinomodelocontroller.do")

public class TreinomodeloController extends HttpServlet {
	public TreinomodeloController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		
		TreinomodeloDAO TremodDAO = new TreinomodeloDAO();
		TipoTreinoDAO tpotreDAO = new TipoTreinoDAO();
		
		String acao = req.getParameter("acao");
		Prof prf = (Prof)req.getSession().getAttribute("prfOK");
		
		if (acao.equals("listar")){
			List<Treinomodelo> lista = TremodDAO.buscarTodosProf(prf.getId_prof());
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaTreinomodeloProf.jsp");
			dispatcher.forward(req, resp);
			
		} else if (acao.equals("novo")){
			Treinomodelo tremod = new Treinomodelo();
			TipoTreino tpotre = new TipoTreino();
			
			tpotre.setId_Tipotreino(0);
			
			tremod.setId_Treinomodelo(0);
			tremod.setNome("");
			tremod.setDescr("");
			tremod.setProf(prf);
			tremod.setTipotreino(tpotre);
			
			req.setAttribute("tremod", tremod);
			
			List<TipoTreino> listatpotre = tpotreDAO.buscarTodos(tremod.getTipotreino().getId_Tipotreino());
			req.setAttribute("listatt", listatpotre);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formtreinomodelo.jsp");
			dispatcher.forward(req, resp);
			
		} else if (acao.equals("alterar")){
			String id = req.getParameter("id");
			
			Treinomodelo tremod = TremodDAO.buscarPorIdTreino(Integer.parseInt(id));
			req.setAttribute("tremod",  tremod);
			
			List<TipoTreino> listatpotre = tpotreDAO.buscarTodosOutros(tremod.getTipotreino().getId_Tipotreino());
			req.setAttribute("listatt", listatpotre);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formtreinomodelo.jsp");
			dispatcher.forward(req, resp);
			
			
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		Treinomodelo tremod = new Treinomodelo();
		TipoTreino tpotre = new TipoTreino();
		Prof prf = (Prof)req.getSession().getAttribute("prfOK");
		
		
		tpotre.setId_Tipotreino(Integer.parseInt(req.getParameter("tipotreino")));
		
		tremod.setTipotreino(tpotre);
		tremod.setProf(prf);
		
		if(req.getParameter("id_treinomodelo")!= "")
			tremod.setId_Treinomodelo(Integer.parseInt(req.getParameter("id_treinomodelo")));
		
		tremod.setNome(req.getParameter("nome"));
		tremod.setDescr(req.getParameter("descr"));
		
		TreinomodeloDAO tremodDAO = new TreinomodeloDAO();
		tremodDAO.salvar(tremod);
		
		req.getRequestDispatcher("WEB-INF/index2.jsp").forward(req, resp);
				
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}

	
	
	
}
