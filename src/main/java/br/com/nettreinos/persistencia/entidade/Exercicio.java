package br.com.nettreinos.persistencia.entidade;

public class Exercicio {
	private Integer id_Exercicio;
	private String Nome;
	private String Linkvideo1;
	private String Linkimg1;
	private String Linkimg2;
	private String Linkimg3;
	private String Descr;
	private Integer Dificuldade;
	private Boolean Ativo;
	public Integer getId_Exercicio() {
		return id_Exercicio;
	}
	public void setId_Exercicio(Integer id_Exercicio) {
		this.id_Exercicio = id_Exercicio;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getLinkvideo1() {
		return Linkvideo1;
	}
	public void setLinkvideo1(String linkvideo1) {
		Linkvideo1 = linkvideo1;
	}
	public String getLinkimg1() {
		return Linkimg1;
	}
	public void setLinkimg1(String linkimg1) {
		Linkimg1 = linkimg1;
	}
	public String getLinkimg2() {
		return Linkimg2;
	}
	public void setLinkimg2(String linkimg2) {
		Linkimg2 = linkimg2;
	}
	public String getLinkimg3() {
		return Linkimg3;
	}
	public void setLinkimg3(String linkimg3) {
		Linkimg3 = linkimg3;
	}
	public String getDescr() {
		return Descr;
	}
	public void setDescr(String descr) {
		Descr = descr;
	}
	public Integer getDificuldade() {
		return Dificuldade;
	}
	public void setDificuldade(Integer dificuldade) {
		Dificuldade = dificuldade;
	}
	public Boolean getAtivo() {
		return Ativo;
	}
	public void setAtivo(Boolean ativo) {
		Ativo = ativo;
	}
	@Override
	public String toString() {
		return "exercicio [id_Exercicio=" + id_Exercicio + ", Nome=" + Nome + ", Linkvideo1=" + Linkvideo1
				+ ", Linkimg1=" + Linkimg1 + ", Linkimg2=" + Linkimg2 + ", Linkimg3=" + Linkimg3 + ", Descr=" + Descr
				+ ", Dificuldade=" + Dificuldade + ", Ativo=" + Ativo + "]";
	}
	
	
}
