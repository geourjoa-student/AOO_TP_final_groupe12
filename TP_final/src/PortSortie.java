import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PortSortie extends Port {

	private List<PortEntree> listePortsConnectes;

	public PortSortie(Composant proprietaire, int id) {
		id_port = id;
		listePortsConnectes = new ArrayList<PortEntree>();
		this.proprietairePort = proprietaire;
	}

	public List<PortEntree> getListePortEntreeConnectes() {
		return listePortsConnectes;
	}

	public void ajouterConnexion(PortEntree p) {
		listePortsConnectes.add(p);

	}

	public void propagerValeur() {
		
		for (Iterator<PortEntree> it = listePortsConnectes.iterator(); it.hasNext();) {
			PortEntree portEntreeCourant = it.next();
			portEntreeCourant.setValeur(valeur);
			
		}
		
	}

}