package br.com.nettreinos.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nettreinos.persistencia.entidade.Exercicio;
import br.com.nettreinos.persistencia.entidade.Treinomodelo;
import br.com.nettreinos.persistencia.entidade.TreinomodeloExercicio;
import br.com.nettreinos.persistencia.jdbc.ExercicioDAO;
import br.com.nettreinos.persistencia.jdbc.TreinomodeloDAO;
import br.com.nettreinos.persistencia.jdbc.TreinomodeloExercicioDAO;

@SuppressWarnings("serial")
@WebServlet("/treinomodeloexerciciocontroller.do")

public class TreinomodeloExercicioController extends HttpServlet {
	
	
	public TreinomodeloExercicioController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		TreinomodeloExercicioDAO tremodexeDAO = new TreinomodeloExercicioDAO();
		TreinomodeloDAO TremodDAO = new TreinomodeloDAO();
		//TipoTreinoDAO tpotreDAO = new TipoTreinoDAO();
		ExercicioDAO exeDAO = new ExercicioDAO();
		
		String acao = req.getParameter("acao");
		
		List<Exercicio> listaexe = exeDAO.buscarTodos();
		req.setAttribute("listaexe", listaexe);
		
		if (acao.equals("abrir")){
			String id = req.getParameter("id");
					
			Treinomodelo tremod = TremodDAO.buscarPorIdTreino(Integer.parseInt(id));
			req.setAttribute("tremod",  tremod);
			
			List<TreinomodeloExercicio> listatme = tremodexeDAO.buscarPorIdTreino(Integer.parseInt(id));
			req.setAttribute("listatme", listatme);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formtreinomodeloexercicio.jsp");
			dispatcher.forward(req, resp);
		} else if (acao.equals("remover")){
			String id_treino = req.getParameter("id_treino");
			String id_exercicio = req.getParameter("id_exercicio");
			
			tremodexeDAO.remover(Integer.parseInt(id_exercicio));
			
			Treinomodelo tremod = TremodDAO.buscarPorIdTreino(Integer.parseInt(id_treino));
			req.setAttribute("tremod",  tremod);
			
			List<TreinomodeloExercicio> listatme = tremodexeDAO.buscarPorIdTreino(Integer.parseInt(id_treino));
			req.setAttribute("listatme", listatme);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formtreinomodeloexercicio.jsp");
			dispatcher.forward(req, resp);
			
			
		} else if (acao.equals("editar")){
			
			String id_treino = req.getParameter("id_treino");
			String id_exercicio = req.getParameter("id_exercicio");
			
			TreinomodeloExercicio tremodexe = tremodexeDAO.buscarPorIdExercicio(Integer.parseInt(id_exercicio));
			req.setAttribute("tremodexe", tremodexe);
			
			Treinomodelo tremod = TremodDAO.buscarPorIdTreino(Integer.parseInt(id_treino));
			req.setAttribute("tremod",  tremod);
			
			List<TreinomodeloExercicio> listatme = tremodexeDAO.buscarPorIdTreino(Integer.parseInt(id_treino));
			req.setAttribute("listatme", listatme);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formtreinomodeloexercicioeditar.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		TreinomodeloExercicio tremodexe = new TreinomodeloExercicio();
		Treinomodelo tremod = new Treinomodelo();
		Exercicio exe = new Exercicio();
		String enviar = req.getParameter("enviar");
		TreinomodeloExercicioDAO tremodexeDAO = new TreinomodeloExercicioDAO();
		ExercicioDAO exeDAO = new ExercicioDAO();
		
		tremod.setId_Treinomodelo(Integer.parseInt(req.getParameter("id_treinomodelo")));
		tremodexe.setTreinomodelo(tremod);
		
		exe.setId_Exercicio(Integer.parseInt(req.getParameter("id_Exercicio")));
		tremodexe.setExercicio(exe);
		
		tremodexe.setDivisao(req.getParameter("divisao"));
		tremodexe.setNumsequencia(Integer.parseInt(req.getParameter("sequencia")));

		tremodexe.setQtderepetcoes(Integer.parseInt(req.getParameter("qtderepeticoes")));
		tremodexe.setQtdeseries(Integer.parseInt(req.getParameter("qtdeseries")));
		tremodexe.setIntervalo(Integer.parseInt(req.getParameter("intervalo")));
		tremodexe.setTempodescanco(Integer.parseInt(req.getParameter("tempodescanco")));
		tremodexe.setCarga(Integer.parseInt(req.getParameter("carga")));
				
		
		if(enviar.equals("inserir")){
			tremodexeDAO.adicionar(tremodexe);
		} else if (enviar.equals("alterar")){
			tremodexe.setId_Treinomodelo_exercicio(Integer.parseInt(req.getParameter("id_treinomodeloexercicio")));
			tremodexeDAO.alterar(tremodexe);
		}
		
		
		List<Exercicio> listaexe = exeDAO.buscarTodos();
		req.setAttribute("listaexe", listaexe);
		
		req.setAttribute("tremod",  tremod);
		List<TreinomodeloExercicio> listatme = tremodexeDAO.buscarPorIdTreino(tremod.getId_Treinomodelo());
		req.setAttribute("listatme", listatme);
		
		req.getRequestDispatcher("WEB-INF/formtreinomodeloexercicio.jsp").forward(req, resp);
	
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}
	
	
}










