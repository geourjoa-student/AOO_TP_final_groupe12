package projet.composant;

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

}
