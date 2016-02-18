package br.com.nettreinos.controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nettreinos.persistencia.entidade.Usuario;
import br.com.nettreinos.persistencia.jdbc.UsuarioDAO;

@SuppressWarnings("serial")
@WebServlet("/usucontroller.do")

public class UsuarioController extends HttpServlet {
	public UsuarioController(){
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		String acao = req.getParameter("acao"); //= "listar"; //
		
		if(acao.equals("listar")){
			List<Usuario> lista = usuDAO.buscarTodos();
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaUsu.jsp");
			dispatcher.forward(req, resp);
			
		} else if(acao.equals("cadastrar")){
			Usuario usu = new Usuario();
			usu.setId_Usuario(0);
			usu.setLogin("");
			usu.setSenha("");
			usu.setId_TipoUsuario(1);
			usu.setAtivo(true);
			req.setAttribute("usu", usu);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formusuario.jsp");
			dispatcher.forward(req, resp);
		} else if(acao.equals("alterar")){
			String id = req.getParameter("id");
			
			Usuario usu = usuDAO.buscarPorId(Integer.parseInt(id));
			req.setAttribute("usu", usu);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formusuario.jsp");
			dispatcher.forward(req, resp);
		} 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		String id_usuario = req.getParameter("id_usuario");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		String id_tipousuario = req.getParameter("id_tipousuario");
		//String ativo = req.getParameter("ativo");

		Usuario usu = new Usuario();
		if(id_usuario != "")
			usu.setId_Usuario(Integer.parseInt(id_usuario));
	
		usu.setLogin(login);
		usu.setSenha(senha);
		usu.setId_TipoUsuario(Integer.parseInt(id_tipousuario));
		usu.setAtivo(true); // ATENCAO - todos usuarios ativo
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		resp.getWriter().print("<h1>Inserido usuário com sucesso</h1>");
		}
	
	@Override
	public void destroy(){
		super.destroy();
	}
}
