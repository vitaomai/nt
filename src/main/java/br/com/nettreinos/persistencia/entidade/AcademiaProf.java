package br.com.nettreinos.persistencia.entidade;
import br.com.nettreinos.persistencia.entidade.Academia;
import br.com.nettreinos.persistencia.entidade.Prof;


public class AcademiaProf {
	private Academia academia;
	private Prof prof;
	
	public Academia getAcademia() {
		return academia;
	}
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	public Prof getProf() {
		return prof;
	}
	public void setProf(Prof prof) {
		this.prof = prof;
	}
	
	@Override
	public String toString() {
		return "AcademiaProf [academia=" + academia + ", prof=" + prof + "]";
	}
	
	
	
	
	
}
