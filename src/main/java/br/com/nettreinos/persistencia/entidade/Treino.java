package br.com.nettreinos.persistencia.entidade;
import java.util.Calendar;

public class Treino {
	private Integer id_Treino;
	private TipoTreino tipotreino;
	private Prof prof;
	private Atleta atleta;
	
	private String nome;
	private String descr;
	private Calendar datainicio;
	private Calendar datafim;
	private Integer frequencia;
	private Boolean ativo;
	public Integer getId_Treino() {
		return id_Treino;
	}
	public void setId_Treino(Integer id_Treino) {
		this.id_Treino = id_Treino;
	}
	public TipoTreino getTipotreino() {
		return tipotreino;
	}
	public void setTipotreino(TipoTreino tipotreino) {
		this.tipotreino = tipotreino;
	}
	public Prof getProf() {
		return prof;
	}
	public void setProf(Prof prof) {
		this.prof = prof;
	}
	public Atleta getAtleta() {
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
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
	public Calendar getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(Calendar datainicio) {
		this.datainicio = datainicio;
	}
	public Calendar getDatafim() {
		return datafim;
	}
	public void setDatafim(Calendar datafim) {
		this.datafim = datafim;
	}
	public Integer getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return "Treino [id_Treino=" + id_Treino + ", tipotreino=" + tipotreino + ", prof=" + prof + ", atleta=" + atleta
				+ ", nome=" + nome + ", descr=" + descr + ", datainicio=" + datainicio + ", datafim=" + datafim
				+ ", frequencia=" + frequencia + ", ativo=" + ativo + "]";
	}
	
	
	
	
}
