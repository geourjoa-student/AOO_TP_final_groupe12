public abstract class Port {

	private boolean valeur;
	
	private Integer id_port;

	private Composant proprietairePort;

	public Integer getId_port() {
		return id_port;
	}

	public Composant getProprietairePort() {
		return proprietairePort;
	}

	public boolean isValeur() {
		return valeur;
	}

	public void setValeur(boolean valeur) {
		this.valeur = valeur;
	}

	
	
}