package br.com.nettreinos.persistencia.entidade;

import java.util.Calendar;
//import java.util.Date;


public class Academia {
	private Integer	id_Academia;
	private String	Nome;
	private String	RazaoSocial;
	private String	Telefone1;
	private String	Telefone2;
	private String	CNPJ;
	private Calendar DataCad;
	private String	Responsavel	;
	private String	Email;
	private String	Site;
	private String	Facebook;
	private String	Endereco;
	private String	Cep;
	private String	Bairro;
	private String	Numero;
	private Integer	id_Cidade;
	private Integer	id_Estado;
	private boolean	Ativo;
	
	public Integer getId_Academia() {
		return id_Academia;
	}
	public void setId_Academia(int id_Academia) {
		this.id_Academia = id_Academia;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getRazaoSocial() {
		return RazaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
	public String getTelefone1() {
		return Telefone1;
	}
	public void setTelefone1(String telefone1) {
		Telefone1 = telefone1;
	}
	public String getTelefone2() {
		return Telefone2;
	}
	public void setTelefone2(String telefone2) {
		Telefone2 = telefone2;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public Calendar getDataCad() {
		return DataCad;
	}
	public void setDataCad(Calendar dataCad) {
		DataCad = dataCad;
	}
	public String getResponsavel() {
		return Responsavel;
	}
	public void setResponsavel(String responsavel) {
		Responsavel = responsavel;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSite() {
		return Site;
	}
	public void setSite(String site) {
		Site = site;
	}
	public String getFacebook() {
		return Facebook;
	}
	public void setFacebook(String facebook) {
		Facebook = facebook;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public Integer getId_Cidade() {
		return id_Cidade;
	}
	public void setId_Cidade(int id_Cidade) {
		this.id_Cidade = id_Cidade;
	}
	public Integer getId_Estado() {
		return id_Estado;
	}
	public void setId_Estado(int id_Estado) {
		this.id_Estado = id_Estado;
	}
	public boolean isAtivo() {
		return Ativo;
	}
	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "Academia [id_Academia=" + id_Academia + ", Nome=" + Nome + ", RazaoSocial=" + RazaoSocial + ", Telefone1="
				+ Telefone1 + ", Telefone2=" + Telefone2 + ", CNPJ=" + CNPJ + ", DataCad=" + DataCad.getTime() + ", Responsavel="
				+ Responsavel + ", Email=" + Email + ", Site=" + Site + ", Facebook=" + Facebook + ", Endereco="
				+ Endereco + ", Cep=" + Cep + ", Bairro=" + Bairro + ", Numero=" + Numero + ", id_Cidade=" + id_Cidade
				+ ", id_Estado=" + id_Estado + ", Ativo=" + Ativo + "]";
	}

	
	
}
