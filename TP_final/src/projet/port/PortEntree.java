package projet.port;
import projet.composant.Composant;

public class PortEntree extends Port {

	private boolean composantConnecte;
	
	public PortEntree(Composant proprietaire, int id) {
		this.id_port = id;
		this.proprietairePort = proprietaire;
		this.composantConnecte=false;
	}

	@Override
	public boolean estConnecte() {
		return composantConnecte;
	}

	public void connecte() {
		composantConnecte=true;
		
	}

}