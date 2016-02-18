package br.com.nettreinos.controller;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.nettreinos.persistencia.entidade.Administrador;
import br.com.nettreinos.persistencia.entidade.Usuario;
import br.com.nettreinos.persistencia.jdbc.AdministradorDAO;

@SuppressWarnings("serial")
@WebServlet("/administradorcontroller.do")
public class AdministradorController extends HttpServlet{

	public AdministradorController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		AdministradorDAO admDAO = new AdministradorDAO();
		
		String acao = req.getParameter("acao");
		Calendar CalendDataCad = Calendar.getInstance();
		
		if(acao.equals("listar")){
			List<Administrador> lista = admDAO.buscarTodos();
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaAdministrador.jsp");
			dispatcher.forward(req, resp);
		} else if (acao.equals("cadastrar")){
			Administrador adm = new Administrador();
			
			adm.setId_admin(0);
			adm.setId_academia(0);
			adm.setNome("");
			adm.setSobrenome("");
			adm.setMatricula(0);
			adm.setAtivo(true);
			adm.setId_usuario(0);
			
			req.setAttribute("adm", adm);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formadministrador.jsp");
			dispatcher.forward(req, resp);
			
		} else if (acao.equals("alterar")){
			String id = req.getParameter("id");
			
			Administrador adm = admDAO.buscarPorId(Integer.parseInt(id));
			req.setAttribute("adm",  adm);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formadministrador.jsp");
			dispatcher.forward(req, resp); 
		} else if (acao.equals("alterarcadastro")){
			Administrador adm = (Administrador)req.getSession().getAttribute("admOK");
			
			//String idusuario = req.getParameter("idusuario");
			//Administrador adm = admDAO.buscarPorIdUsuario(adm.getId_admin());
			//adm = admDAO.buscarPorId(adm.getId_admin());
			req.setAttribute("adm", adm);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formadministrador.jsp");
			dispatcher.forward(req, resp);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		
		String id_admin = req.getParameter("Id_admin");
		Integer id_academia = Integer.parseInt(req.getParameter("Id_academia"));
		String nome = req.getParameter("Nome");
		String sobrenome = req.getParameter("Sobrenome");
		Integer matricula = Integer.parseInt(req.getParameter("Matricula"));
		Boolean ativo = Boolean.parseBoolean(req.getParameter("Ativo"));
		Integer id_usuario = Integer.parseInt(req.getParameter("Id_usuario"));
		
		Administrador adm = new Administrador();
		if(id_admin != "")
			adm.setId_admin(Integer.parseInt(id_admin));
		
		adm.setId_academia(id_academia);
		adm.setNome(nome);
		adm.setSobrenome(sobrenome);
		adm.setMatricula(matricula);
		adm.setAtivo(ativo);
		adm.setId_usuario(id_usuario);
		
		AdministradorDAO admDAO = new AdministradorDAO();
		admDAO.salvar(adm);
		
		HttpSession sessao = req.getSession();
		
		Usuario usu = (Usuario)sessao.getAttribute("usuOK");
		Integer id_usr = usu.getId_Usuario();
		adm = admDAO.buscarPorIdUsuario(id_usr);
		sessao.setAttribute("admOK", adm);
		
		/*resp.getWriter().print("<h1>Administrador salvo com sucesso</h1> <br>" + 
					"<a href='administradorcontroller.do?acao=listar'> Listar Administradores </a>");*/
		req.getRequestDispatcher("WEB-INF/index2.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}
	
}
