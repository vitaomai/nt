package br.com.nettreinos.persistencia.entidade;

public class TipoUsuario {
	private Integer id_TipoUsuario;
	private String Nome;
	private String Descr;
	private boolean Ativo;
	
	public Integer getId_TipoUsuario() {
		return id_TipoUsuario;
	}
	public void setId_TipoUsuario(Integer id_TipoUsuario) {
		this.id_TipoUsuario = id_TipoUsuario;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDescr() {
		return Descr;
	}
	public void setDescr(String descr) {
		Descr = descr;
	}
	
	@Override
	public String toString() {
		return "TipoUsuario [id_TipoUsuario=" + id_TipoUsuario + ", Nome=" + Nome + ", Descr=" + Descr + ", Ativo=" + Ativo + "]";
	}
	public boolean isAtivo() {
		return Ativo;
	}
	public void setAtivo(boolean ativo) {
		this.Ativo = ativo;
	}
	
}
