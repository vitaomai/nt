package br.com.nettreinos.persistencia.entidade;

public class TipoTreino {
	private Integer id_Tipotreino;
	private String nome;
	private String descr;
	public Integer getId_Tipotreino() {
		return id_Tipotreino;
	}
	public void setId_Tipotreino(Integer id_Tipotreino) {
		this.id_Tipotreino = id_Tipotreino;
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
	
	@Override
	public String toString() {
		return "tipotreino [id_Tipotreino=" + id_Tipotreino + ", nome=" + nome + ", descr=" + descr
				+ ", getId_Tipotreino()=" + getId_Tipotreino() + ", getNome()=" + getNome() + ", getDescr()="
				+ getDescr() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}
