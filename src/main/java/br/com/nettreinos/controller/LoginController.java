package br.com.nettreinos.controller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import br.com.nettreinos.persistencia.entidade.Administrador;
import br.com.nettreinos.persistencia.entidade.Atleta;
import br.com.nettreinos.persistencia.entidade.Prof;
import br.com.nettreinos.persistencia.entidade.Usuario;
import br.com.nettreinos.persistencia.jdbc.AdministradorDAO;
import br.com.nettreinos.persistencia.jdbc.AtletaDAO;
import br.com.nettreinos.persistencia.jdbc.ProfDAO;
import br.com.nettreinos.persistencia.jdbc.UsuarioDAO;

@SuppressWarnings("serial")
@WebServlet("/loginController.do")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		HttpSession sessao = req.getSession(false);
		
		if(sessao!=null){
			sessao.invalidate();
		}
		resp.sendRedirect("index.html");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usu = new Usuario();
		usu.setLogin(login);
		usu.setSenha(senha);
		UsuarioDAO UsuDAO = new UsuarioDAO();
		Usuario usuAutenticado = UsuDAO.autenticar(usu);
		if(usuAutenticado!=null){
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuOK", usuAutenticado);
			Integer id_usr = usuAutenticado.getId_Usuario();
			Integer tpouser = usuAutenticado.getId_TipoUsuario();
			// identifica qual é o usuario e então pega o seu "avatar"(atleta, adm, prof ou geral)
			if(tpouser==1){
				// este é o adm SEVERINO - em breve terá utilidade.
			} else if(tpouser==2){
				ProfDAO prfDAO = new ProfDAO();
				Prof prf = prfDAO.buscarPorIdUsuario(id_usr);
				sessao.setAttribute("prfOK", prf);
			} else if (tpouser==3){
				AdministradorDAO admDAO = new AdministradorDAO();
				Administrador adm = admDAO.buscarPorIdUsuario(id_usr);
				sessao.setAttribute("admOK", adm);
			}else if(tpouser==4){
				AtletaDAO atlDAO = new AtletaDAO();
				Atleta atl = atlDAO.buscarPorIdUsuario(id_usr);
				sessao.setAttribute("atlOK", atl);
			}
			
			sessao.setMaxInactiveInterval(5000);
			
			req.getRequestDispatcher("WEB-INF/index2.jsp").forward(req, resp);
			
		} else{
			resp.getWriter().print("<script>window.alert('Nome de usuario ou senha inválidos'); location.href='index.html';</script>)");

		}
	}
}
