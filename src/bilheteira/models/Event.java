package bilheteira.models;

/**
 * Classe model evento contem o ID do event (eventoID), o nome do evento (nome), 
 * o preço base do evento (preço da zona mais barata) (precoBase) e data e hora do
 * evento (dataHora)
 * 
 * @author TheRenas
 *
 */
	public class Event {
		private int eventoID;
		private String nome;
		private double precoBase;
		private String dataHora;
		
		/**
		 * Construtor da classe Event que recebe estes parametros e 
		 * atrubui os seus valores aos parametros da classe;
		 * @param eventoID:  ID do event
		 * @param nome:      nome do evento
		 * @param dataHora:  data e hora do evento
		 * @param precoBase: preço base do evento (preço da zona mais barata)
		 */
		public Event(int eventoID,String nome,String dataHora,double precoBase) {
			this.eventoID = eventoID;
			this.nome = nome;
			this.dataHora = dataHora;
			//this.lugaresDisponiveis = lugaresDisponiveis;
			this.precoBase = precoBase;
		}
		
		/**
		 * Metodo getter para o nome;
		 * 
		 * @return uma string com o nome do evento
		 */
		public String getNome() {
			return nome;
		}

		@Override
		/**
		 * metodo toString;
		 * 
		 * @return chama o metodo getNome que devolve uma string com o nome do evento
		 */
		public String toString() {
			return getNome();
		}

		/**
		 * Metodo getter para o precoBase;
		 * 
		 * @return um double com o precoBase
		 */
		public double getPrecoBase() {
			return precoBase;
		}

		/**
		 * Metodo getter para o EventoID;
		 * 
		 * @return um inteiro com o eventoID
		 */
		public int getEventoID() {
			return eventoID;
		}

		/**
		 * Metodo getter para a dataHora;
		 * 
		 * @return uma string com a dataHora
		 */
		public String getDataHora() {
			return dataHora;
		}
	}

