package bilheteira.models;

/**
 * Classe model bilhete contem:
 * o codigo do bilhete (um id para o bilhete) (codigoBilhete), 
 * um boolean para dar a indicação se o bilhete foi usado (entrada),
 * a data e hora em que o bilhete foi comprado,
 * o preço do bilhete (precoBilhete),
 * o ID do utilizador que vendeu o bilhete (userID_bilhete) e
 * o ID da ligação entre evento e zona, para ter a informação da zona para um determinado evento (eventoZonaID_bilhete)
 * @author TheRenas
 *
 */
public class Bilhete {

	private int codigoBilhete;
	private boolean entrada;
	private String tempoBilhete;
	private double precoBilhete;
	private int userID_bilhete;
	private int eventoZonaID_bilhete;
	
	/**
	 * Construtor da classe Bilhete que recebe estes parametros e 
	 * atrubui os seus valores aos parametros da classe;
	 * @param codigoBilhete: codigo do bilhete
	 * @param entrada: boolean para dar a indicação se o bilhete foi usado
	 * @param tempoBilhete: data e hora em que o bilhete foi comrado,
	 * @param precoBilhete: preço  do bilhete
	 * @param userID_bilhete: ID do utilizador que vendeu o bilhete
	 * @param eventoZonaID_bilhete: ID da ligação entre evento e zona, para ter a informação da zona para uma determinado evento
	 */
	public Bilhete(int codigoBilhete, boolean entrada, String tempoBilhete, double precoBilhete,
			int userID_bilhete, int eventoZonaID_bilhete) {
		this.codigoBilhete = codigoBilhete;
		this.entrada = entrada;
		this.tempoBilhete = tempoBilhete;
		this.precoBilhete = precoBilhete;
		this.userID_bilhete = userID_bilhete;
		this.eventoZonaID_bilhete = eventoZonaID_bilhete;
		
		
	}
	
}
