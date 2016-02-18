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
import br.com.nettreinos.persistencia.entidade.AcademiaProf;
import br.com.nettreinos.persistencia.entidade.Administrador;
import br.com.nettreinos.persistencia.entidade.Prof;
import br.com.nettreinos.persistencia.jdbc.AcademiaDAO;
import br.com.nettreinos.persistencia.jdbc.AcademiaProfDAO;
import br.com.nettreinos.persistencia.jdbc.ProfDAO;


@SuppressWarnings("serial")
@WebServlet("/academiaprofcontroller.do")

public class AcademiaProfController extends HttpServlet {
	public AcademiaProfController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		
		AcademiaProfDAO acadprfDAO = new AcademiaProfDAO();		
		AcademiaDAO acadDAO = new AcademiaDAO();
		ProfDAO prfDAO = new ProfDAO();
		
		String acao = req.getParameter("acao");
		// como é utilizada a mesma classe para acessos do relacionamento prof e academia, a seguir tenta pegar da sessao o 'adm'ou o 'prof'.
		Prof prf = (Prof) req.getSession().getAttribute("prfOK"); 
		Administrador adm = (Administrador) req.getSession().getAttribute("admOK");
	

		if(acao.equals("listaracademias")){ // litsar academia do professor, user logado como professor.
			List<AcademiaProf> lista = acadprfDAO.buscarAcadProf_idprf(prf.getId_prof());
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaAcademiaProf.jsp");
			dispatcher.forward(req, resp);
		} else if(acao.equals("listarprofs")){ //listar professores da academia, solicitado pelo user ADM da academia
			List<AcademiaProf> lista = acadprfDAO.buscarAcadProf_idadm(adm.getId_academia());
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaProfAcademia.jsp");
			dispatcher.forward(req, resp);
			
		} else if (acao.equals("buscar")){ //listar professores da academia, solicitado pelo user ADM da academia 
			List<Prof> lista = acadprfDAO.buscarProf_nome(req.getParameter("nome")); //listar professores da academia, solicitado pelo user ADM da academia
			
			req.setAttribute("lista", lista);			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/VincularAcademiaProf.jsp");
			dispatcher.forward(req, resp); 
			
		} else if (acao.equals("vincular")){ //vincular profesor à academia, feito pelo usuario Admin da Academia.
			Academia acad = acadDAO.buscarPorId(adm.getId_academia());
			prf = prfDAO.buscarPorId(Integer.parseInt(req.getParameter("id_prof")));
			
			AcademiaProf acadprf = new AcademiaProf();
			acadprf.setAcademia(acad);
			acadprf.setProf(prf);
			
			acadprfDAO.inserir(acadprf); // cria o vinculo entre academia e prof, com base a solciitação do user ADM da academia
			//listar professores da academia, solicitado pelo user ADM da academia
			List<AcademiaProf> lista = acadprfDAO.buscarAcadProf_idadm(adm.getId_academia());
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaProfAcademia.jsp");
			dispatcher.forward(req, resp);
			
		}
	}
	
	
	
	@Override
	public void destroy(){
		super.destroy();
	}
}
