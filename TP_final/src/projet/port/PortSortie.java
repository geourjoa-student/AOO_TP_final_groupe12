package projet.port;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import projet.composant.Composant;

public class PortSortie extends Port {

	private List<PortEntree> portsConnectes;

	public PortSortie(Composant proprietaire, int id) {
		id_port = id;
		portsConnectes = new ArrayList<PortEntree>();
		this.proprietairePort = proprietaire;
	}

	public List<PortEntree> getListePortEntreeConnectes() {
		return portsConnectes;
	}

	public void ajouterConnexion(PortEntree p) {
		portsConnectes.add(p);
		p.connecte();

	}

	public void propagerValeur() {
		
		for (Iterator<PortEntree> it = portsConnectes.iterator(); it.hasNext();) {
			PortEntree portEntreeCourant = it.next();
			portEntreeCourant.setValeur(valeur);
			
		}
		
	}

	@Override
	public boolean estConnecte() {
		return (portsConnectes.size()>0);
	}

}