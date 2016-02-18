package br.com.nettreinos.persistencia.entidade;

import java.util.Calendar;

public class Datatreino {
	private Integer id_datatreino;
	private Treino treino;
	private Calendar datatreino;
	private String divisao;
	
	public Integer getId_datatreino() {
		return id_datatreino;
	}
	public void setId_datatreino(Integer id_datatreino) {
		this.id_datatreino = id_datatreino;
	}
	public Treino getTreino() {
		return treino;
	}
	public void setTreino(Treino treino) {
		this.treino = treino;
	}
	public Calendar getDatatreino() {
		return datatreino;
	}
	public void setDatatreino(Calendar datatreino) {
		this.datatreino = datatreino;
	}
	
	
	public String getDivisao() {
		return divisao;
	}
	public void setDivisao(String divisao) {
		this.divisao = divisao;
	}
	@Override
	public String toString() {
		return "Datatreino [id_datatreino=" + id_datatreino + ", treino=" + treino + ", datatreino=" + datatreino
				+ ", divisao=" + divisao + "]";
	}
	
	
	
	
}
