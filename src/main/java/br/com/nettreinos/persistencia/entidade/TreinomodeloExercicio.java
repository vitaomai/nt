package br.com.nettreinos.persistencia.entidade;

public class TreinomodeloExercicio {
	private Integer id_TreinomodeloExercicio;
	private Exercicio exercicio;
	private Treinomodelo treinomodelo;
	private Integer qtderepetcoes;
	private Integer qtdeseries;
	private Integer intervalo;
	private Integer tempodescanco;
	private String divisao;
	private Integer numsequencia;
	private Integer carga;
	
	public Integer getId_TreinomodeloExercicio() {
		return id_TreinomodeloExercicio;
	}
	public void setId_Treinomodelo_exercicio(Integer id_TreinomodeloExercicio) {
		this.id_TreinomodeloExercicio = id_TreinomodeloExercicio;
	}
	public Exercicio getExercicio() {
		return exercicio;
	}
	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}
	public Treinomodelo getTreinomodelo() {
		return treinomodelo;
	}
	public void setTreinomodelo(Treinomodelo treinomodelo) {
		this.treinomodelo = treinomodelo;
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
		return "Treinomodelo_exercicio [id_Treinomodelo_exercicio=" + id_TreinomodeloExercicio + ", exercicio="
				+ exercicio + ", treinomodelo=" + treinomodelo + ", qtderepetcoes=" + qtderepetcoes + ", qtdeseries="
				+ qtdeseries + ", intervalo=" + intervalo + ", tempodescanco=" + tempodescanco + ", divisao=" + divisao
				+ ", numsequencia=" + numsequencia + ", carga=" + carga + "]";
	}
	
	
	
	
}
