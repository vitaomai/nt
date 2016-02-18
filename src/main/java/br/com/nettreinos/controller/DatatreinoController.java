package br.com.nettreinos.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nettreinos.persistencia.entidade.Datatreino;
import br.com.nettreinos.persistencia.entidade.Treino;
import br.com.nettreinos.persistencia.entidade.TreinoExercicio;
import br.com.nettreinos.persistencia.jdbc.DatatreinoDAO;
import br.com.nettreinos.persistencia.jdbc.TreinoExercicioDAO;

@SuppressWarnings("serial")
@WebServlet("/datatreinocontroller.do")


public class DatatreinoController extends HttpServlet {
	
	public DatatreinoController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		resp.setContentType("text/html");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		Datatreino dtatre = new Datatreino();
		DatatreinoDAO dtatreDAO = new DatatreinoDAO();
		Treino tre = new Treino();
		TreinoExercicioDAO treexeDAO = new TreinoExercicioDAO();
		
		Calendar CalendDataTreino = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Integer id_treino = Integer.parseInt(req.getParameter("id_treino"));
		
		tre.setId_Treino(id_treino);
		dtatre.setDivisao(req.getParameter("divisao"));
		try{
			String datatreino = req.getParameter("datatreino");
			CalendDataTreino.setTime(sdf.parse(datatreino));
		}catch (ParseException e) {
			e.printStackTrace();
		}
		dtatre.setDatatreino(CalendDataTreino);
		
		dtatre.setTreino(tre);
		
		dtatreDAO.inserir(dtatre);
		
		req.setAttribute("id_treino", id_treino);
		
		List<Datatreino> listadt = dtatreDAO.buscarTodos(id_treino); 
		req.setAttribute("listadt", listadt);
		
		List<TreinoExercicio> listate = treexeDAO.buscarPorIdTreino(id_treino);
		req.setAttribute("listate", listate);
		
		req.getRequestDispatcher("WEB-INF/ListaTreinoExercicio.jsp").forward(req, resp);
	}
	
	
	@Override
	public void destroy(){
		super.destroy();
	}
	
}







