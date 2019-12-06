package bilheteira.models;

	public class Event {
		private int eventoID;
		private String nome;
		private int precoBase;
		private String dia;
		private int lugaresDisponiveis;
		public Event(int eventoID,String nome,String dia,int precoBase,int lugaresDisponiveis) {
			this.eventoID = eventoID;
			this.nome = nome;
			this.dia = dia;
			this.lugaresDisponiveis = lugaresDisponiveis;
			this.precoBase = precoBase;
		}
		public String getNome() {
			return nome;
		}
		@Override
		public String toString() {
			return  getNome();
		}
		
		public String getDescription() {
			return nome ;
					
			}
	
		public int getPrecoBase() {
			return precoBase;
		}
		
		public int getEventoID() {
			return eventoID;
		}
		
		public int getLugatesDiponiveis() {
			return lugaresDisponiveis;
			}
		
		public String getDia() {
			return dia;
		}
		
		//public static void add(EventsList eventsList) {}
		
		
	}
