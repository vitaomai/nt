package br.com.nettreinos.persistencia.entidade;

public class Usuario {
	private Integer id_usuario;
	private String login;
	private String senha;
	private Integer id_tipousuario;
	private Boolean ativo;
	
	
	public Integer getId_Usuario() {
		return id_usuario;
	}
	public void setId_Usuario(Integer iduser) {
		this.id_usuario = iduser;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getId_TipoUsuario() {
		return id_tipousuario;
	}
	public void setId_TipoUsuario(Integer idtipouser) {
		this.id_tipousuario = idtipouser;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "Usuario encontrado: [idUser=" + id_usuario + ", Login=" + login + ", Senha=" + senha + ", idTipoUser" + id_tipousuario + ", Ativo=" + ativo + "]";
	}
	

}
