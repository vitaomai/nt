package br.com.nettreinos.persistencia.entidade;
import br.com.nettreinos.persistencia.entidade.Academia;
import br.com.nettreinos.persistencia.entidade.Atleta;

public class AcademiaAtleta {
	private Academia academia;
	private Atleta atleta;
	
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
	
	@Override
	public String toString() {
		return "AcademiaAtleta [academia=" + academia + ", atleta=" + atleta + "]";
	}
	
	
	
}
