package br.com.nettreinos.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import br.com.nettreinos.persistencia.entidade.Treino;
import br.com.nettreinos.persistencia.entidade.TreinoExercicio;
import br.com.nettreinos.persistencia.entidade.Treinomodelo;
import br.com.nettreinos.persistencia.entidade.TreinomodeloExercicio;
import br.com.nettreinos.persistencia.jdbc.AtletaProfDAO;
import br.com.nettreinos.persistencia.jdbc.TipoTreinoDAO;
import br.com.nettreinos.persistencia.jdbc.TreinoDAO;
import br.com.nettreinos.persistencia.jdbc.TreinoExercicioDAO;
import br.com.nettreinos.persistencia.jdbc.TreinomodeloDAO;
import br.com.nettreinos.persistencia.jdbc.TreinomodeloExercicioDAO;




@SuppressWarnings("serial")
@WebServlet("/treinocontroller.do")


public class TreinoController extends HttpServlet {
	public TreinoController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		TreinoDAO treDAO = new TreinoDAO();
		TreinoExercicioDAO treexeDAO = new TreinoExercicioDAO();
		TreinomodeloDAO tremodDAO = new TreinomodeloDAO();
		TreinomodeloExercicioDAO tremodexeDAO = new TreinomodeloExercicioDAO();
		TipoTreinoDAO tpotre = new TipoTreinoDAO();
		AtletaProfDAO atlprfDAO = new AtletaProfDAO();
		
		String acao = req.getParameter("acao");
		Prof prf = (Prof)req.getSession().getAttribute("prfOK");
		Atleta atl = new Atleta();
		
		
		if (acao.equals("enviar")){
			//Buscar lista de atlas do professor
			List<AtletaProf> lista = atlprfDAO.buscarAtleProf_idprf(prf.getId_prof());
			req.setAttribute("lista", lista);
						
			Treinomodelo tremod = tremodDAO.buscarPorIdTreino(Integer.parseInt(req.getParameter("id_treino")));
			req.setAttribute("tremod", tremod);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/VincularTreinoAtleta.jsp");
			dispatcher.forward(req, resp);
		}	else if(acao.equals("vincular")){
			//Atleta atl = new Atleta();
			Treino tre = new Treino();
			
			atl.setId_atleta(Integer.parseInt(req.getParameter("id_atleta")));
			
			// buscar a lista de atltas do professor, pois após vincular voltará para a mesma página de envios de treino.
			List<AtletaProf> lista = atlprfDAO.buscarAtleProf_idprf(prf.getId_prof());
			req.setAttribute("lista", lista);
			
			//pega os dados do treino modelo em questão (que será enviado ao atleta)
			Treinomodelo tremod = tremodDAO.buscarPorIdTreino(Integer.parseInt(req.getParameter("id_treinomodelo")));
			req.setAttribute("tremod", tremod);
			
			//pega a lista de Exercicio que consta no treino em questão.
			List<TreinomodeloExercicio> listatme =  tremodexeDAO.buscarPorIdTreino(Integer.parseInt(req.getParameter("id_treinomodelo")));
			req.setAttribute("listatme", listatme);
			
			tre.setAtleta(atl);
			tre.setProf(prf);
			tre.setTipotreino(tremod.getTipotreino());
			tre.setNome(tremod.getNome());
			tre.setDescr(tremod.getDescr());
			//vincular treino modelo ao atleta (i.e. criar um treino)			
			treDAO.vincular(tre);
			//pega o id do treino que acaou de ser inserido
			Integer Id_treino = treDAO.buscarMaxPorIdTreino(tre);
			tre.setId_Treino(Id_treino); 
			
			
			List<TreinoExercicio> listate = new ArrayList<TreinoExercicio>();
			//vincular exercicio modelo ao atleta (insere os exerciciosmodelos em uma lista de exercicio e insere no banco)
			for(TreinomodeloExercicio tme:listatme){
				TreinoExercicio treexe = new TreinoExercicio();
				treexe.setTreino(tre);
				treexe.setExercicio(tme.getExercicio());
				treexe.setQtderepetcoes(tme.getQtderepetcoes());
				treexe.setQtdeseries(tme.getQtdeseries());
				treexe.setIntervalo(tme.getIntervalo());
				treexe.setTempodescanco(tme.getTempodescanco());
				treexe.setDivisao(tme.getDivisao());
				treexe.setNumsequencia(tme.getNumsequencia());
				listate.add(treexe);
				//treexeDAO.vincular(treexe);				
			}			
			treexeDAO.vincular(listate);			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/VincularTreinoAtleta.jsp");
			dispatcher.forward(req, resp);
		} else if(acao.equals("abrir")){
			atl = (Atleta)req.getSession().getAttribute("atlOK");
			
			List<Treino> listatre = treDAO.buscarPorIdAtleta(atl.getId_atleta());
			req.setAttribute("lista", listatre);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaTreino.jsp");
			dispatcher.forward(req, resp);			
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}

}
