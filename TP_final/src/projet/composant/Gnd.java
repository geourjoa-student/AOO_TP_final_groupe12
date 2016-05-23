package projet.composant;

import java.util.Iterator;

import projet.port.PortEntree;
import projet.port.PortSortie;

/**
 * @author anthony
 *
 *         Repréente le concept d'une composant électronique Gnd qui fournit un
 *         niveau 0
 */
public class Gnd extends Generateur {

	public Gnd(int id) {

		nbPortsEntree = 0;
		nbPortsSortie = 1;

		portsSorties = new PortSortie[nbPortsSortie];

		portsSorties[0] = new PortSortie(this, 0);
		portsSorties[0].setValeur(false);
		this.id = id;
	}

	@Override
	public void calculerSorties() {
		portsSorties[0].propagerValeur();
	}

	@Override
	public String toString() {

		String s = "<" + id + "| Gnd (" + 0 + "," + portsSorties.length + ") -> ";

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
