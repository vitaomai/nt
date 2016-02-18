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

import br.com.nettreinos.persistencia.entidade.Prof;
import br.com.nettreinos.persistencia.entidade.Usuario;
import br.com.nettreinos.persistencia.jdbc.ProfDAO;


@SuppressWarnings("serial")
@WebServlet("/profcontroller.do")

public class ProfController extends HttpServlet {
	
	public ProfController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		
		ProfDAO prfDAO = new ProfDAO();
		String acao = req.getParameter("acao");
		Calendar CalendDatanasc = Calendar.getInstance();
		
		if(acao.equals("listar")){
			List<Prof> lista = prfDAO.buscarTodos();
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaProf.jsp");
			dispatcher.forward(req, resp);
			
		} else if(acao.equals("cadastrar")){
			Prof prf = new Prof();
			prf.setId_prof(0);
			prf.setId_usuario(25);
			prf.setNome("");
			prf.setSobrenome("");
			prf.setApelido("");
			prf.setTelefone1("");
			prf.setTelefone2("");
			prf.setCpf("");
			prf.setFoto("");
			prf.setDatanasc(CalendDatanasc);
			prf.setEmail("");
			prf.setSite("");
			prf.setFacebook("");
			prf.setEndereco("");
			prf.setNumero("");
			prf.setCep("");
			prf.setBairro("");
			prf.setId_cidade(1);
			prf.setId_estado(1);
			prf.setNumconselho(2);
			prf.setAtivo(true);
			req.setAttribute("prf", prf);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formprof.jsp");
			dispatcher.forward(req, resp);
			
		} else if (acao.equals("alterar")){
			String id = req.getParameter("id");
			Prof prf = prfDAO.buscarPorId(Integer.parseInt(id));
			req.setAttribute("prf", prf);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formprof.jsp");
			dispatcher.forward(req, resp);
		} else if (acao.equals("alterarcadastro")){
			Prof prf = (Prof)req.getSession().getAttribute("prfOK");
			req.setAttribute("prf", prf);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formprof.jsp");
			dispatcher.forward(req, resp);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		Calendar CalendDatanasc = Calendar.getInstance();
	
		String id_prof = req.getParameter("Id_prof");
		String id_usuario = req.getParameter("Id_usuario");
		String nome = req.getParameter("Nome");
		String sobrenome = req.getParameter("Sobrenome");
		String apelido = req.getParameter("Apelido");
		String telefone1 = req.getParameter("Telefone1");
		String telefone2 = req.getParameter("Telefone2");
		String cpf = req.getParameter("Cpf");
		String foto = req.getParameter("Foto");
		String datanasc = req.getParameter("Datanasc");
		String email = req.getParameter("Email");
		String site = req.getParameter("Site");
		String facebook = req.getParameter("Facebook");
		String endereco = req.getParameter("Endereco");
		String numero = req.getParameter("Numero");
		String cep = req.getParameter("Cep");
		String bairro = req.getParameter("Bairro");
		String id_cidade = req.getParameter("Id_cidade");
		String id_estado = req.getParameter("Id_estado");
		String numconselho = req.getParameter("Numconselho");
		String ativo = req.getParameter("Ativo");

		Prof prf = new Prof();
		if (id_prof != "")
			prf.setId_prof(Integer.parseInt(id_prof));
		
		prf.setId_usuario(Integer.parseInt(id_usuario));
		prf.setNome(nome);
		prf.setSobrenome(sobrenome);
		prf.setApelido(apelido);
		prf.setTelefone1(telefone1);
		prf.setTelefone2(telefone2);
		prf.setCpf(cpf);
		prf.setFoto(foto);
		prf.setDatanasc(CalendDatanasc);
		prf.setEmail(email);
		prf.setSite(site);
		prf.setFacebook(facebook);
		prf.setEndereco(endereco);
		prf.setNumero(numero);
		prf.setCep(cep);
		prf.setBairro(bairro);
		prf.setId_cidade(1);
		prf.setId_estado(1);
		prf.setNumconselho(Integer.parseInt(numconselho));
		prf.setAtivo(Boolean.parseBoolean(ativo));
		
		ProfDAO prfDAO = new ProfDAO();
		prfDAO.salvar(prf);
		
		// atualiza a sessao com os dados do prof alterados. faz a busca basenado-se no ID do Usuário
		HttpSession sessao = req.getSession();
		Usuario usu = (Usuario)sessao.getAttribute("usuOK");
		Integer id_usr = usu.getId_Usuario();
		prf = prfDAO.buscarPorIdUsuario(id_usr);
		sessao.setAttribute("prfOK", prf);
		
		req.getRequestDispatcher("WEB-INF/index2.jsp").forward(req, resp);
		
	}	
}
		
