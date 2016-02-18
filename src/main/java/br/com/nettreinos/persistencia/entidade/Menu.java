package br.com.nettreinos.persistencia.entidade;

public class Menu {
	private Integer id_menuadm;
	private String item;
	private String descr;
	private Integer id_tipousuario;
	private Integer id_perfilacesso;
	private Boolean ativo;
	private String link;
	
	public Integer getId_menuadm() {
		return id_menuadm;
	}
	public void setId_menuadm(Integer id_menuadm) {
		this.id_menuadm = id_menuadm;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Integer getId_tipousuario() {
		return id_tipousuario;
	}
	public void setId_tipousuario(Integer id_tipousuario) {
		this.id_tipousuario = id_tipousuario;
	}
	public Integer getId_perfilacesso() {
		return id_perfilacesso;
	}
	public void setId_perfilacesso(Integer id_perfilacesso) {
		this.id_perfilacesso = id_perfilacesso;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}
