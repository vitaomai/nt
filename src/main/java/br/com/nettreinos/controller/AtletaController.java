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

import br.com.nettreinos.persistencia.entidade.Atleta;
import br.com.nettreinos.persistencia.entidade.Usuario;
import br.com.nettreinos.persistencia.jdbc.AtletaDAO;

@SuppressWarnings("serial")
@WebServlet("/atletacontroller.do")

public class AtletaController extends HttpServlet {
	
	public AtletaController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		AtletaDAO atlDAO = new AtletaDAO();
		
		String acao = req.getParameter("acao");
		Calendar CalendDatanasc = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		if (acao.equals("listar")){
			List<Atleta> lista = atlDAO.buscarTodos();
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaAtleta.jsp");
			dispatcher.forward(req, resp);
		} else if(acao.equals("cadastrar")){
			Atleta atl = new Atleta();
			atl.setId_atleta(0);
			atl.setNome("");
			atl.setSobrenome("");
			atl.setApelido("");
			atl.setAtivo(true);
			atl.setTelefone1("");
			atl.setTelefone2("");
			atl.setCpf("");
			atl.setFoto("");
			atl.setDatanasc(CalendDatanasc);
			atl.setEmail("");
			atl.setFacebook("");
			atl.setEndereco("");
			atl.setCep("");
			atl.setBairro("");
			atl.setNumero("");
			atl.setId_cidade(1);
			atl.setId_estado(2);
			req.setAttribute("atl", atl);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formatleta.jsp");
			dispatcher.forward(req, resp);
		}else if(acao.equals("alterar")){ // faz alteração do atleta a partir da listagem do Severino.
			String id = req.getParameter("id");
			
			Atleta atl = atlDAO.buscarPorId(Integer.parseInt(id));
			req.setAttribute("atl",  atl);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formatleta.jsp");
			dispatcher.forward(req, resp);
		}else if(acao.equals("alterarcadastro")){ //faz alteração do cadastro do atleta a partir do login do próprio atleta
			Atleta atl = (Atleta) req.getSession().getAttribute("atlOK");

			req.setAttribute("atl",  atl);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formatleta.jsp");
			dispatcher.forward(req, resp);
		} 
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		Calendar CalendDatanasc = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//java.sql.Date DateDatanasc = new java.sql.Date(CalendDatanasc.getTime().getTime());
				
		String id_atleta  = req.getParameter("id_atleta");
		String id_usuario = req.getParameter("id_usuario");
		String nome = req.getParameter("Nome");
		String sobrenome = req.getParameter("Sobrenome");
		String apelido = req.getParameter("Apelido");
		//String ativo = req.getParameter("Ativo");
		String telefone1 = req.getParameter("Telefone1");
		String telefone2 = req.getParameter("Telefone2");
		String cpf = req.getParameter("Cpf");
		String foto = req.getParameter("Foto");
		try{
			String datanasc = req.getParameter("DataNasc");
			CalendDatanasc.setTime(sdf.parse(datanasc));
		}catch (ParseException e) {
			e.printStackTrace();
		}
		String email = req.getParameter("Email");
		String facebook = req.getParameter("Facebook");
		String endereco = req.getParameter("Endereco");
		String cep = req.getParameter("Cep");
		String bairro = req.getParameter("Bairro");
		String numero = req.getParameter("Numero");
		String id_cidade = req.getParameter("id_cidade");
		String id_estado = req.getParameter("id_estado");
		
		Atleta atl = new Atleta();
		if(id_atleta != "")
			atl.setId_atleta(Integer.parseInt(id_atleta));
			
		atl.setId_usuario(Integer.parseInt(id_usuario));
		atl.setNome(nome);
		atl.setSobrenome(sobrenome);
		atl.setApelido(apelido);
		atl.setAtivo(true); // CHUMBADO TRUE
		atl.setTelefone1(telefone1);
		atl.setTelefone2(telefone2);
		atl.setCpf(cpf);
		atl.setFoto(foto);
		atl.setDatanasc(CalendDatanasc);
		atl.setEmail(email);
		atl.setFacebook(facebook);
		atl.setEndereco(endereco);
		atl.setCep(cep);
		atl.setBairro(bairro);
		atl.setNumero(numero);
		atl.setId_cidade(Integer.parseInt(id_cidade));
		atl.setId_estado(Integer.parseInt(id_estado));
		
		AtletaDAO atlDAO = new AtletaDAO();
		atlDAO.salvar(atl);
		// atualiza a sessao do usuário pós o mesmo editar 
		HttpSession sessao = req.getSession();
		Usuario usu = (Usuario)sessao.getAttribute("usuOK");
		Integer id_usr = usu.getId_Usuario();
		atl = atlDAO.buscarPorIdUsuario(id_usr);
		sessao.setAttribute("atlOK", atl);
		
		/*resp.getWriter().print("<h1>Atleta salvo com sucesso</h1> <br>" + 
					"<a href='atletacontroller.do?acao=listar'> Listar atletas </a>");*/
		//resp.getWriter().print("<script>window.alert('*** Atleta salvo com sucesso! ***');</script>)");
		req.getRequestDispatcher("WEB-INF/index2.jsp").forward(req, resp);
	}

	@Override
	public void destroy(){
		super.destroy();
	}

}
