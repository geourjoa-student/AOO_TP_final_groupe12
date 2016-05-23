package projet.composant;

import java.util.Iterator;

import projet.exception.PortInconnuException;
import projet.port.PortEntree;
import projet.port.PortSortie;

/**
 * @author anthony
 *
 *         Classe abstraite permettant de généraliser des fonctions associés aux
 *         composants élémentaires (Et, Ou, etc)
 */
public abstract class Elementaire implements Composant {

	protected int id;

	protected PortEntree[] portsEntrees;

	protected PortSortie[] portsSorties;

	protected int nbPortsSortie;

	protected int nbPortsEntree;

	public int getId() {
		return id;
	}

	public int getNbPortsSorties() {
		return nbPortsSortie;
	}

	public int getNbPortsEntrees() {
		return nbPortsEntree;
	}

	public PortSortie getNiemePortSortie(int n) throws PortInconnuException {
		if (n >= nbPortsSortie)
			throw new PortInconnuException();
		return portsSorties[n];
	}

	@Override
	public PortEntree getNiemePortEntree(int n) throws PortInconnuException {
		if (n >= nbPortsEntree)
			throw new PortInconnuException();
		return portsEntrees[n];
	}

	public boolean portsTousConnectes() {
		for (int i = 0; i < nbPortsEntree; i++) {
			if (!portsEntrees[i].estConnecte())
				return false;
		}

		for (int i = 0; i < nbPortsSortie; i++) {
			if (!portsSorties[i].estConnecte())
				return false;
		}

		return true;
	}
	
	@Override
	public String toString() {

		String s = "<" + id + "| " + this.getClass().getSimpleName() +" (" + nbPortsEntree + "," + nbPortsSortie + ") -> ";

		for (int i = 0; i < portsSorties.length; i++) {
			s += "#" + portsSorties[i].getId_port() + "(";

			for (Iterator<PortEntree> it = portsSorties[i].getListePortEntreeConnectes().iterator(); it.hasNext();) {
				PortEntree pe = it.next();
				s += pe.getProprietairePort().getId() + "#" + pe.getId_port();

				if (it.hasNext()) {
					s += ",";
				}
			}
			s += ")";
		}

		s += ">";

		return s;
	}
}