package projet.composant;

import projet.port.PortSortie;

public class Gen4bc2 extends Generateur {
	
	private int valeur;
	
	public Gen4bc2(int id) {
		nbPortsEntree=0;
		nbPortsSortie=4;
		
		portsSorties = new PortSortie[nbPortsSortie];
		
		for (int i = 0; i < nbPortsSortie; i++) {
			portsSorties[i] = new PortSortie(this,i);
			portsSorties[i].setValeur(false);		
		}
		
		
		this.id=id;
	}

	@Override
	public void calculerSorties() {
		// TODO Auto-generated method stub
		
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	

}
