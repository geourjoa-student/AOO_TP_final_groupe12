package projet.composant;

import projet.port.PortSortie;

/**
 * @author anthony
 *
 *         Repréente le concept d'une composant électronique Gnd qui fournit un
 *         niveau 0
 */
public class Vcc extends Generateur {
	
	//static final private int nbPortsSorties = 1;
	
	@Override
	public void calculerSorties()
	{
		portsSorties[0].propagerValeur();
	}

	public Vcc(int id) {
		nbPortsEntree=0;
		nbPortsSortie=1;

		portsSorties = new PortSortie[nbPortsSortie];
		
		portsSorties[0] = new PortSortie(this,0);
		
		portsSorties[0].setValeur(true);
		this.id = id;
	}

	
}