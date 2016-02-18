package br.com.nettreinos.persistencia.entidade;

public class TreinoExercicio {
	private Integer id_treinoexercicio;
	private Exercicio exercicio;
	private Treino treino;
	
	private Integer qtderepetcoes;
	private Integer qtdeseries;
	private Integer intervalo;
	private Integer tempodescanco;
	private String divisao;
	private Integer numsequencia;
	private Integer carga;
	
	public Integer getId_treinoexercicio() {
		return id_treinoexercicio;
	}
	public void setId_treinoexercicio(Integer id_treinoexercicio) {
		this.id_treinoexercicio = id_treinoexercicio;
	}
	public Exercicio getExercicio() {
		return exercicio;
	}
	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}
	public Treino getTreino() {
		return treino;
	}
	public void setTreino(Treino treino) {
		this.treino = treino;
	}
	public Integer getQtderepetcoes() {
		return qtderepetcoes;
	}
	public void setQtderepetcoes(Integer qtderepetcoes) {
		this.qtderepetcoes = qtderepetcoes;
	}
	public Integer getQtdeseries() {
		return qtdeseries;
	}
	public void setQtdeseries(Integer qtdeseries) {
		this.qtdeseries = qtdeseries;
	}
	public Integer getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}
	public Integer getTempodescanco() {
		return tempodescanco;
	}
	public void setTempodescanco(Integer tempodescanco) {
		this.tempodescanco = tempodescanco;
	}
	public String getDivisao() {
		return divisao;
	}
	public void setDivisao(String divisao) {
		this.divisao = divisao;
	}
	public Integer getNumsequencia() {
		return numsequencia;
	}
	public void setNumsequencia(Integer numsequencia) {
		this.numsequencia = numsequencia;
	}
	public Integer getCarga() {
		return carga;
	}
	public void setCarga(Integer carga) {
		this.carga = carga;
	}
	@Override
	public String toString() {
		return "Treino_exercicio [id_treino_exercicio=" + id_treinoexercicio + ", exercicio=" + exercicio + ", treino="
				+ treino + ", qtderepetcoes=" + qtderepetcoes + ", qtdeseries=" + qtdeseries + ", intervalo="
				+ intervalo + ", tempodescanco=" + tempodescanco + ", divisao=" + divisao + ", numsequencia="
				+ numsequencia + ", carga=" + carga + "]";
	}
	
	
	
}
