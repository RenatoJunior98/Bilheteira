package bilheteira.models;

public class Bilhete {

	private String nome;
	private int codigoBilhete;
	private boolean entrada;
	private String tempoBilhete;
	private double precoBilhete;
	private int userID_bilhete;
	private int eventoZonaID_bilhete;
	
	public Bilhete(String nome, int codigoBilhete, boolean entrada, String tempoBilhete, double precoBilhete,
			int userID_bilhete, int eventoZonaID_bilhete) {
		this.nome = nome;
		this.codigoBilhete = codigoBilhete;
		this.entrada = entrada;
		this.tempoBilhete = tempoBilhete;
		this.precoBilhete = precoBilhete;
		this.userID_bilhete = userID_bilhete;
		this.eventoZonaID_bilhete = eventoZonaID_bilhete;
	
	
	
	}
	
	
	
	
	
}
