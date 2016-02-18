package br.com.nettreinos.persistencia.entidade;

public class Treinomodelo {
	private Integer id_Treinomodelo;
	private String nome;
	private String descr;
	private TipoTreino tipotreino;
	private Academia academia;
	private Prof prof;
	private Boolean ativo;
	
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Integer getId_Treinomodelo() {
		return id_Treinomodelo;
	}
	public void setId_Treinomodelo(Integer id_Treinomodelo) {
		this.id_Treinomodelo = id_Treinomodelo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public TipoTreino getTipotreino() {
		return tipotreino;
	}
	public void setTipotreino(TipoTreino tipotreino) {
		this.tipotreino = tipotreino;
	}
	public Academia getAcademia() {
		return academia;
	}
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	public Prof getProf() {
		return prof;
	}
	public void setProf(Prof prof) {
		this.prof = prof;
	}
	@Override
	public String toString() {
		return "treinomodelo [id_Treinomodelo=" + id_Treinomodelo + ", nome=" + nome + ", descr=" + descr
				+ ", tipotreino=" + tipotreino + ", academia=" + academia + ", prof=" + prof + ", ativo=" + ativo + "]";
	}
	
	
	
}
