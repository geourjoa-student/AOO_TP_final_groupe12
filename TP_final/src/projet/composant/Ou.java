package projet.composant;

import projet.port.PortEntree;
import projet.port.PortSortie;

/**
 * @author anthony
 *
 *         Repréente le concept d'une composant électronique Ou
 */
public class Ou extends Transformateur {

	public Ou(int id) {

		nbPortsEntree = 2;
		nbPortsSortie = 1;
		portsEntrees = new PortEntree[nbPortsEntree];
		portsSorties = new PortSortie[nbPortsSortie];

		portsEntrees[0] = new PortEntree(this, 0);
		portsEntrees[1] = new PortEntree(this, 1);

		portsSorties[0] = new PortSortie(this, 0);

		this.id = id;
	}

	@Override
	public void calculerSorties() {
		this.portsSorties[0].setValeur(this.portsEntrees[0].isValeur() || this.portsEntrees[1].isValeur());
		portsSorties[0].propagerValeur();
	}
}