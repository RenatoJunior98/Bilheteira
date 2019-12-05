package application.view;

	public class EventsList {
		private int id;
		private String nome;
		private int precoBase;
		private String dia;
		private int lugaresDisponiveis;
		public EventsList(int id,String nome,String dia,int precoBase,int lugaresDisponiveis) {
			this.id = id;
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
		
		public int getId() {
			return id;
		}
		
		public int getLugatesDiponiveis() {
			return lugaresDisponiveis;
			}
		
		public String getDia() {
			return dia;
		}
		
		//public static void add(EventsList eventsList) {}
		
		
	}
