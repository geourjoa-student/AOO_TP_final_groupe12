public class PortEntree extends Port {

	public Port composantConnecte;
	
	public PortEntree(Composant proprietaire, int id) {
		this.id_port = id;
		this.proprietairePort = proprietaire;
	}

}