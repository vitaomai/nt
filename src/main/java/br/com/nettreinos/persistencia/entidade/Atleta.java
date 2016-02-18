package br.com.nettreinos.persistencia.entidade;

import java.util.Calendar;

public class Atleta {
	private Integer id_atleta;
	private Integer id_usuario;
	private String nome;
	private String sobrenome;
	private String apelido;
	private Boolean ativo;
	private String telefone1;
	private String telefone2;
	private String cpf;
	private String foto;
	private Calendar datanasc;
	private String email;
	private String facebook;
	private String endereco;
	private String cep;
	private String bairro;
	private String numero;
	private Integer id_cidade;
	private Integer id_estado;
	
	public Integer getId_atleta() {
		return id_atleta;
	}
	public void setId_atleta(Integer id_atleta) {
		this.id_atleta = id_atleta;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
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
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Calendar getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(Calendar datanasc) {
		this.datanasc = datanasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getId_cidade() {
		return id_cidade;
	}
	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	@Override
	public String toString() {
		return "Atleta [id_atleta=" + id_atleta + ", id_usuario=" + id_usuario + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", apelido=" + apelido + ", ativo=" + ativo + ", telefone1=" + telefone1 + ", telefone2="
				+ telefone2 + ", cpf=" + cpf + ", foto=" + foto + ", datanasc=" + datanasc + ", email=" + email
				+ ", facebook=" + facebook + ", endereco=" + endereco + ", cep=" + cep + ", bairro=" + bairro
				+ ", numero=" + numero + ", id_cidade=" + id_cidade + ", id_estado=" + id_estado + "]";
	}
	
	

}
