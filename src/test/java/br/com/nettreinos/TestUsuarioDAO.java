package br.com.nettreinos;

import java.util.Calendar;
//import java.util.Calendar;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.*;
import br.com.nettreinos.persistencia.jdbc.*;


public class TestUsuarioDAO {

public static void main(String[] args) {
	
	// ### TESTES USUARIO ###
	// UsuarioInsert();
	// UsuarioAlter();
	// UsuarioDesativ();
	// UsuarioBuscartodos();
	// UsuarioBuscarPorId();
		
	// ### TESTES ACADEMIA ###
	// AcademiaInsert();
	// AcademiaAlter();
	// AcademiaDesativ();
	// AcademiaBuscarTodos();
	//AcademiaBuscarPorId();
	
	// ### TESTES TIPOUSUARIO ###
	//TipoUsuarioInsert();
	//TipoUsuarioAlter();
	//TipoUsuarioDesativar();
	//TipoUsuarioExcluir();
	//TipoUsuarioBuscarPorId();
	//TipoUsuarioBuscarTodos();
	
	// ### TESTES TIPOUSUARIO ###
	//TipoUsuarioInsert();
	//TipoUsuarioAlter();
	//TipoUsuarioDesativar();
	//TipoUsuarioExcluir();
	//TipoUsuarioBuscarPorId();
	//TipoUsuarioBuscarTodos();
	
	// ### TESTES ATLETA ###
	//AtletaInsert();
	//AtletaAlter();
	//AtletaDesativar();
	//AtletaBuscarTodos();
	//AtletaBuscarPorId();
	
	// ### TESTES PROF ###
	// ProfInsert();
	// ProfAlter();
	//ProfDesativar();
	//ProfBuscarTodos();
	//ProfBuscarPorId();
	
	// ### TESTES ADM ###
	//AdministradorInsert();
	//AdministradorAlter();
	//AdministradorDesativar();
	//AdministradorBuscarTodos();
	//AdministradorBuscarPorId();

	// ### TESTES ATLETA - PROFESSOR ###
	AtlPrfBuscarTodos();
}
	

	private static void UsuarioInsert(){
		Usuario Usuario = new Usuario();
		UsuarioDAO UDAO = new UsuarioDAO();
		
		Usuario.setLogin("TestUser");
		Usuario.setSenha("testuser");
		Usuario.setId_TipoUsuario(1);
		Usuario.setAtivo(true);
		
		UDAO.inserir(Usuario);
	}

	private static void UsuarioAlter(){
		Usuario Usuario = new Usuario();
		UsuarioDAO UDAO = new UsuarioDAO();
		Usuario.setId_Usuario(24);
		Usuario.setLogin("UserTest");
		Usuario.setSenha("usertest");
		Usuario.setId_TipoUsuario(1);
		Usuario.setAtivo(true);
		
		UDAO.alterar(Usuario);
		
	}

	private static void UsuarioDesativ(){
		Usuario Usuario = new Usuario();
		UsuarioDAO UDAO = new UsuarioDAO();
		Usuario.setId_Usuario(24);
		Usuario.setAtivo(true);

		UDAO.desativar(Usuario);
	}
	
	private static void UsuarioBuscartodos(){
		UsuarioDAO UDAO = new UsuarioDAO();
		List<Usuario> lista = UDAO.buscarTodos();
		
		for (Usuario u: lista){
			System.out.println(u);
		}
	}

	private static void UsuarioBuscarPorId(){
		Usuario Usuario = new Usuario();
		UsuarioDAO UDAO = new UsuarioDAO();
		Usuario.setId_Usuario(6);

		Usuario UsuRetorno = UDAO.buscarPorId(Usuario.getId_Usuario());
		
		System.out.println(UsuRetorno);
	}

	/* ------------------------------------------*/
	public static void AcademiaInsert(){
		Academia Ac = new Academia();
		AcademiaDAO AcDAO = new AcademiaDAO();
		Calendar c = Calendar.getInstance();
		c.set(2014, 11, 31);
		
		Ac.setNome("Peralta");
		Ac.setRazaoSocial("Peralta Academia ME LTDA");
		Ac.setTelefone1("1145323245");
		Ac.setTelefone2("");
		Ac.setCNPJ("01010100000145");
		Ac.setDataCad(c);
		Ac.setResponsavel("Josélio");
		Ac.setEmail("zeze@gmail.com");
		Ac.setSite("www.peralta.com.br");
		Ac.setFacebook("facebook.com/peraltafitness");
		Ac.setEndereco("Av. Nss. Sra. Sabara");
		Ac.setCep("04627-002");
		Ac.setBairro("Vila Sofia");
		Ac.setNumero("301");
		Ac.setId_Cidade(4);
		Ac.setId_Estado(5);
		Ac.setAtivo(true);
		
		AcDAO.inserir(Ac);
	}
	
	public static void AcademiaAlter(){
		Academia Ac = new Academia();
		AcademiaDAO AcDAO = new AcademiaDAO();
		Calendar c = Calendar.getInstance();
		c.set(2012, 10, 01);
		
		Ac.setId_Academia(5);
		Ac.setNome("Space Fit");
		Ac.setRazaoSocial("Space Fit LTDA");
		Ac.setTelefone1("1132453245");
		Ac.setTelefone2("119987878787");
		Ac.setCNPJ("32122321000145");
		Ac.setDataCad(c);
		Ac.setResponsavel("Hulk");
		Ac.setEmail("hulk@gmail.com");
		Ac.setSite("www.spacefit.com.br");
		Ac.setFacebook("facebook.com/speacefit");
		Ac.setEndereco("Av. Corifeu de Azevedo Marques, ");
		Ac.setCep("05581-000");
		Ac.setBairro("Butatã");
		Ac.setNumero("25");
		Ac.setId_Cidade(4);
		Ac.setId_Estado(5);
		Ac.setAtivo(true);
		
		AcDAO.alterar(Ac);
	}

	public static void AcademiaDesativ(){
		
		Academia Ac = new Academia();
		AcademiaDAO AcDAO = new AcademiaDAO();

		Ac.setId_Academia(5);
		
		AcDAO.desativar(Ac);
		
	}
	
	public static void AcademiaBuscarTodos(){
		AcademiaDAO AcaDAO = new AcademiaDAO();
		List <Academia> lista = AcaDAO.buscarTodos();
		
		for (Academia a: lista){
			System.out.println(a);
		}
	}
	
	private static void AcademiaBuscarPorId(){
		Academia Acad = new Academia();
		AcademiaDAO AcaDAO = new AcademiaDAO();
		Acad.setId_Academia(2);
		

		Academia AcadRetorno = AcaDAO.buscarPorId(2);
		System.out.println(AcadRetorno);
	}
	
	/* ------------------------------------------*/
	private static void TipoUsuarioInsert(){
		TipoUsuario TpoUsu = new TipoUsuario();
		TipoUsuarioDAO TipUsuDAO = new TipoUsuarioDAO();
		
		TpoUsu.setNome("tipo 5");
		TpoUsu.setDescr("tipo descricao 555 ");
		TpoUsu.setAtivo(true);
		
		TipUsuDAO.inserir(TpoUsu);
	}

	private static void TipoUsuarioAlter(){
		TipoUsuario TpoUsu = new TipoUsuario();
		TipoUsuarioDAO TipUsuDAO = new TipoUsuarioDAO();
		
		TpoUsu.setId_TipoUsuario(4);
		TpoUsu.setNome("tipinho 5 ");
		TpoUsu.setDescr("tipinho dscricao 5 FIVE");
		TpoUsu.setAtivo(true);
		
		TipUsuDAO.alterar(TpoUsu);
	}
	
	private static void TipoUsuarioExcluir(){
		TipoUsuario TpoUsu = new TipoUsuario();
		TipoUsuarioDAO TipUsuDAO = new TipoUsuarioDAO();
		
		TpoUsu.setId_TipoUsuario(5);
		TpoUsu.setNome("tipinho");
		TpoUsu.setDescr("tipinho dscricao");
		TpoUsu.setAtivo(true);
		
		TipUsuDAO.excluir(TpoUsu);
	}
	
	private static void TipoUsuarioDesativar(){
		TipoUsuario TpoUsu = new TipoUsuario();
		TipoUsuarioDAO TipUsuDAO = new TipoUsuarioDAO();
		
		TpoUsu.setId_TipoUsuario(5);
		TpoUsu.setNome("tipinho");
		TpoUsu.setDescr("tipinho dscricao");
		TpoUsu.setAtivo(false);
		
		TipUsuDAO.desativar(TpoUsu);
	}
	
	private static void TipoUsuarioBuscarPorId(){
		TipoUsuario TpoUsu = new TipoUsuario();
		TipoUsuarioDAO TipUsuDAO = new TipoUsuarioDAO();
		
		TpoUsu.setId_TipoUsuario(1);
		

		TipoUsuario TipUsuRetorno = TipUsuDAO.buscarPorId(TpoUsu);
		System.out.println(TipUsuRetorno);
	}
	
	public static void TipoUsuarioBuscarTodos(){
		TipoUsuarioDAO TipUsuDAO = new TipoUsuarioDAO();
		List <TipoUsuario> lista = TipUsuDAO.buscarTodos();

		for (TipoUsuario TU: lista){
			System.out.println(TU);
		}
	}
	
	/* ------------------------------------------*/
	
	public static void AtletaInsert(){
		Atleta Atle = new Atleta();
		AtletaDAO AtleDAO = new AtletaDAO();
		
		Calendar c = Calendar.getInstance();
		c.set(2014, 11, 31);
		
		Atle.setId_usuario(24);
		Atle.setNome("Romario");
		Atle.setSobrenome("Tetra");
		Atle.setApelido("Baixinho");
		Atle.setAtivo(true);
		Atle.setTelefone1("1187574512");
		Atle.setTelefone2("2154547845");
		Atle.setCpf("313112365478");
		Atle.setFoto("");
		Atle.setDatanasc(c);
		Atle.setEmail("romario@gmail.com");
		Atle.setFacebook("facebook.com/romario");
		Atle.setEndereco("av. Nossa senhora de copacabana");
		Atle.setCep("2145878");
		Atle.setBairro("Copacabana");
		Atle.setNumero("457");
		Atle.setId_cidade(1);
		Atle.setId_estado(1);
		
		AtleDAO.inserir(Atle);
	}
	
	public static void AtletaAlter(){
		Atleta Atle = new Atleta();
		AtletaDAO AtleDAO = new AtletaDAO();
		
		Calendar c = Calendar.getInstance();
		c.set(1970, 11, 31);
		Atle.setId_atleta(18);
		Atle.setId_usuario(24);
		Atle.setNome("Romario");
		Atle.setSobrenome("Vereador");
		Atle.setApelido("Baixinho");
		Atle.setAtivo(true);
		Atle.setTelefone1("1187574512");
		Atle.setTelefone2("2154547845");
		Atle.setCpf("313112365478");
		Atle.setFoto("");
		Atle.setDatanasc(c);
		Atle.setEmail("romario_camara@gmail.com");
		Atle.setFacebook("facebook.com/romario");
		Atle.setEndereco("av. Nossa senhora");
		Atle.setCep("02145878");
		Atle.setBairro("Asa Norte");
		Atle.setNumero("457");
		Atle.setId_cidade(1);
		Atle.setId_estado(1);
		
		AtleDAO.alterar(Atle);
	}
	
	private static void AtletaDesativar(){

		Atleta Atle = new Atleta();
		AtletaDAO AtleDAO = new AtletaDAO();
		
		Atle.setId_atleta(18);
		Atle.setAtivo(false);
		
		AtleDAO.desativar(Atle);
	}
	
	public static void AtletaBuscarTodos(){
		AtletaDAO AtleDAO = new AtletaDAO();
		List <Atleta> lista = AtleDAO.buscarTodos();

		for (Atleta At: lista){
			System.out.println(At);
		}
	}
	
	public static void AtletaBuscarPorId(){
		Atleta Atle = new Atleta();
		AtletaDAO AtleDAO = new AtletaDAO();
		
		Atle.setId_atleta(5);
		
		Atleta AtleRetorno = AtleDAO.buscarPorId(5);
		System.out.println(AtleRetorno);
		
		
		
	}

	/* ------------------------------------------*/
	
	public static void ProfInsert(){
		Prof Prf = new Prof();
		ProfDAO PrfDAO = new ProfDAO();
		
		Calendar c = Calendar.getInstance();
		c.set(2014, 11, 31);
		
		Prf.setId_usuario(25);
		Prf.setNome("Aristeles");
		Prf.setSobrenome("Silva");
		Prf.setApelido("Prof. Tite");
		Prf.setTelefone1("1145457878");
		Prf.setTelefone2("1145454545");
		Prf.setCpf("1245678998");
		Prf.setFoto("c:/fotos/img454781225");
		Prf.setDatanasc(c);
		Prf.setEmail("tite@ig.com.br");
		Prf.setSite("");
		Prf.setFacebook("");
		Prf.setEndereco("");
		Prf.setNumero("");
		Prf.setCep("");
		Prf.setBairro("");
		Prf.setId_cidade(2);
		Prf.setId_estado(1);
		Prf.setNumconselho(1);
		Prf.setAtivo(true);
	
		PrfDAO.inserir(Prf);
	}
	
	public static void ProfAlter(){
		Prof Prf = new Prof();
		ProfDAO PrfDAO = new ProfDAO();
		
		Calendar c = Calendar.getInstance();
		c.set(1970, 11, 31);
		
		Prf.setId_prof(5);
		Prf.setId_usuario(25);
		Prf.setNome("Mano");
		Prf.setSobrenome("Menezes");
		Prf.setApelido("Mano");
		Prf.setTelefone1("1145457878");
		Prf.setTelefone2("1145454545");
		Prf.setCpf("1245678998");
		Prf.setFoto("c:/fotos/img4545471225");
		Prf.setDatanasc(c);
		Prf.setEmail("mano@ig.com.br");
		Prf.setSite("www.mano.com.br");
		Prf.setFacebook("facebook.com/mano");
		Prf.setEndereco("");
		Prf.setNumero("");
		Prf.setCep("");
		Prf.setBairro("");
		Prf.setId_cidade(1);
		Prf.setId_estado(1);
		Prf.setNumconselho(1);
		Prf.setAtivo(true);
		
		PrfDAO.alterar(Prf);
	}

	private static void ProfDesativar(){

		Prof Prf = new Prof();
		ProfDAO PrfDAO = new ProfDAO();
		
		Prf.setId_prof(5);
		Prf.setAtivo(false);
		
		PrfDAO.desativar(Prf);
	}
	
	public static void ProfBuscarTodos(){
		ProfDAO PrfDAO = new ProfDAO();
		List <Prof> lista = PrfDAO.buscarTodos();

		for (Prof Pr: lista){
			System.out.println(Pr);
		}
	}
	
	public static void ProfBuscarPorId(){
		Prof Prf = new Prof();
		ProfDAO PrfDAO = new ProfDAO();
		
		Prf.setId_prof(5);
		
		Prof PrfRetorno = PrfDAO.buscarPorId(5);
		System.out.println(PrfRetorno);
			
	}
	
	/* ------------------------------------------*/
	
	public static void AdministradorInsert(){
		Administrador Adm = new Administrador();
		AdministradorDAO AdmDAO = new AdministradorDAO();
		
		Adm.setId_academia(1);
		Adm.setNome	("Maria");
		Adm.setSobrenome("da Penha");
		Adm.setMatricula(454);
		Adm.setAtivo(true);
		Adm.setId_usuario(26);

		AdmDAO.inserir(Adm);
	}
	
	public static void AdministradorAlter(){
		Administrador Adm = new Administrador();
		AdministradorDAO AdmDAO = new AdministradorDAO();
		
		Adm.setId_admin(4);
		Adm.setId_academia(3);
		Adm.setNome	("Maria");
		Adm.setSobrenome("do rosario");
		Adm.setMatricula(454);
		Adm.setAtivo(true);
		Adm.setId_usuario(26);
		
		AdmDAO.alterar(Adm);
	}
	
	private static void AdministradorDesativar(){

		Administrador Adm = new Administrador();
		AdministradorDAO AdmDAO = new AdministradorDAO();
		
		Adm.setId_admin(4);
		Adm.setAtivo(true);
		
		 AdmDAO.desativar(Adm);
	}
	
	/*private static void AdministradorBuscarTodos(){
		AdministradorDAO AdmDAO = new AdministradorDAO();
		List <Administrador> lista = AdmDAO.buscarTodos();
		for (Administrador Ad: lista){
			System.out.println(Ad);
		}
	} */
	
	/*
	   private static void AdministradorBuscarPorId(){
		//Administrador Adm = new Administrador();
		AdministradorDAO AdmDAO = new AdministradorDAO();
		
		//Adm.setId_admin(4);
		
		Administrador AdmRetorno = AdmDAO.buscarPorId(4);
		System.out.println(AdmRetorno);
		
	}*/

	// -----------------------------------

	public static void AtlPrfBuscarTodos(){
		AtletaProfDAO atlProfDAO = new AtletaProfDAO();
		List <AtletaProf> lista = atlProfDAO.buscarTodos();
		
		for (AtletaProf AP: lista){
			System.out.print("Atleta - " + AP.getAtleta().getNome() + "\n");
			System.out.print("Professor - " + AP.getProf().getNome() + "\n");
			System.out.print("\n ****************************** \n");
		}
	}
	
}
