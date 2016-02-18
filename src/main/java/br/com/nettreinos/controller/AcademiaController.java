package br.com.nettreinos.controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.nettreinos.persistencia.entidade.Academia;
import br.com.nettreinos.persistencia.entidade.Administrador;
import br.com.nettreinos.persistencia.entidade.Usuario;
import br.com.nettreinos.persistencia.jdbc.AcademiaDAO;

@SuppressWarnings("serial")
@WebServlet("/academiacontroller.do")
public class AcademiaController extends HttpServlet {
	
	public AcademiaController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		
		AcademiaDAO acadDAO = new AcademiaDAO();
		String acao = req.getParameter("acao");
		
		Calendar CalendDatacad = Calendar.getInstance();
		
		if(acao.equals("listar")){
			List<Academia> lista = acadDAO.buscarTodos();
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaAcademia.jsp");
			dispatcher.forward(req, resp);
			
		} else if(acao.equals("cadastrar")){
			Academia acad = new Academia();
			
			acad.setId_Academia(0);
			acad.setNome("");
			acad.setRazaoSocial("");
			acad.setTelefone1("");
			acad.setTelefone2("");
			acad.setCNPJ("");
			acad.setDataCad(CalendDatacad);
			acad.setResponsavel("");
			acad.setEmail("");
			acad.setSite("");
			acad.setFacebook("");
			acad.setEndereco("");
			acad.setCep("");
			acad.setBairro("");
			acad.setNumero("");
			acad.setId_Cidade(1);
			acad.setId_Estado(1);
			acad.setAtivo(true);
			req.setAttribute("acad", acad);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formacademia.jsp");
			dispatcher.forward(req, resp);
			
		} else if(acao.equals("alterar")){ // faz a alteração do cadastro a partir do Severino (login ADM do sistema)
			String id = req.getParameter("id");
			Academia acad = acadDAO.buscarPorId(Integer.parseInt(id));
			req.setAttribute("acad", acad);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formacademia.jsp");
			dispatcher.forward(req,  resp);
		} else if(acao.equals("cadastroadmacademia")){ // faz a alteração do cadastro a partir do login de adm.
			Administrador adm = (Administrador)req.getSession().getAttribute("admOK");
			
			Academia acad = acadDAO.buscarPorId(adm.getId_academia());
			req.setAttribute("acad", acad);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formacademia.jsp");
			dispatcher.forward(req,  resp);
		} 
	
	}
	
	
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		Calendar CalendDatacad = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String id_academia = req.getParameter("id_academia");
		String Nome = req.getParameter("Nome"); 
		String Razaosocial = req.getParameter("Razaosocial"); 
		String Telefone1 = req.getParameter("Telefone1"); 
		String Telefone2 = req.getParameter("Telefone2"); 
		String CNPJ = req.getParameter("CNPJ"); 
		try{
			String Datacad = req.getParameter("Datacad");
			CalendDatacad.setTime(sdf.parse(Datacad));
		}catch (ParseException e) {
			e.printStackTrace();
		}
		String Responsavel = req.getParameter("Responsavel"); 
		String Email = req.getParameter("Email"); 
		String Site= req.getParameter("Site"); 
		String Facebook= req.getParameter("Facebook"); 
		String Endereco= req.getParameter("Endereco"); 
		String Cep = req.getParameter("Cep"); 
		String Bairro = req.getParameter("Bairro"); 
		String Numero = req.getParameter("Numero"); 
		//String Id_cidade = req.getParameter("Id_cidade"); 
		//String Id_estado = req.getParameter("Id_estado"); 
		String Ativo = req.getParameter("Ativo"); 
		
		Academia acad = new Academia();
		if(id_academia != "")
			acad.setId_Academia(Integer.parseInt(id_academia));
		
		acad.setNome(Nome);
		acad.setRazaoSocial(Razaosocial);
		acad.setTelefone1(Telefone1);
		acad.setTelefone2(Telefone2);
		acad.setCNPJ(CNPJ);
		acad.setDataCad(CalendDatacad);
		acad.setResponsavel(Responsavel);
		acad.setEmail(Email);
		acad.setSite(Site);
		acad.setFacebook(Facebook);
		acad.setEndereco(Endereco);
		acad.setCep(Cep);
		acad.setBairro(Bairro);
		acad.setNumero(Numero);
		acad.setId_Cidade(2);
		acad.setId_Estado(1);
		acad.setAtivo(Boolean.parseBoolean(Ativo));
		
		AcademiaDAO acadDAO = new AcademiaDAO();
		acadDAO.salvar(acad);
		req.getRequestDispatcher("WEB-INF/index2.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}
}
