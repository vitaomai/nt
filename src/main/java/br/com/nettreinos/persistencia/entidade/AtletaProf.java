package br.com.nettreinos.persistencia.entidade;
import br.com.nettreinos.persistencia.entidade.Atleta;
import br.com.nettreinos.persistencia.entidade.Prof;

public class AtletaProf {
	private Atleta atleta;
	private Prof prof;
	
	
	public Atleta getAtleta()  {
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
		return "AtletaProf [atleta=" + atleta + ", prof=" + prof + ", getAtleta()=" + getAtleta() + ", getProf()="
				+ getProf() + "]";
	}
	
	
	
	
	
}
