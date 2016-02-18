package br.com.nettreinos.persistencia.entidade;
import br.com.nettreinos.persistencia.entidade.Academia;
import br.com.nettreinos.persistencia.entidade.Atleta;
import br.com.nettreinos.persistencia.entidade.Prof;


public class AcademiaAtletaProf {
	private Academia academia;
	private Atleta atleta;
	private Prof prof;
	
	public Academia getAcademia() {
		return academia;
	}
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	public Atleta getAtleta() {
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public Prof getProf() {
		return prof;
	}
	public void setProf(Prof prof) {
		this.prof = prof;
	}
	@Override
	public String toString() {
		return "AcademiaAtletaProf [academia=" + academia + ", atleta=" + atleta + ", prof=" + prof + "]";
	}
	
	
	
}
