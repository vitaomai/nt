package br.com.nettreinos.persistencia.entidade;

public class Administrador {
	private Integer id_admin;
	private Integer id_academia;
	private String nome;
	private String sobrenome;
	private Integer matricula;
	private Boolean ativo;
	private Integer id_usuario;
	
	public Integer getId_admin() {
		return id_admin;
	}
	public void setId_admin(Integer id_admin) {
		this.id_admin = id_admin;
	}
	public Integer getId_academia() {
		return id_academia;
	}
	public void setId_academia(Integer id_academia) {
		this.id_academia = id_academia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	@Override
	public String toString() {
		return "Administrador [id_admin=" + id_admin + ", id_academia=" + id_academia + ", nome=" + nome
				+ ", sobrenome=" + sobrenome + ", matricula=" + matricula + ", ativo=" + ativo + ", id_usuario="
				+ id_usuario + "]";
	}
	
	
	
}
