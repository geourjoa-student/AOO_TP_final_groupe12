public abstract class Port {

	protected boolean valeur;
	
	protected Integer id_port;

	protected Composant proprietairePort;

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