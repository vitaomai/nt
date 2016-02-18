package br.com.nettreinos;
import java.util.Calendar;

public class testesGerais {
	public static void Main(String[] args){
		Calendar c;
		
		System.out.println("------------Calendar C---------------");
		
		c = Calendar.getInstance();
		c.set(2015, 12, 31);
		System.out.println(c);
		
	}
}
