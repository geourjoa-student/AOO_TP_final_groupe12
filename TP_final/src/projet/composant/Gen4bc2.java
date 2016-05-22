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
		
		this.valeur=0;
		
		
		this.id=id;
	}

	@Override
	public void calculerSorties() {
		if (valeur < 0)
		{
			portsSorties[0].setValeur(true);
			if (valeur > -5) portsSorties[1].setValeur(true);
			if (valeur == -1 | valeur == -2 | valeur == -5 | valeur == -6) portsSorties[2].setValeur(true);
		}
		else
		{
			if (valeur - 4 >= 0) portsSorties[1].setValeur(true);
			if (valeur == 2 | valeur == 6 | valeur == 7) portsSorties[2].setValeur(true);
		}
		if (valeur % 2 != 0) portsSorties[3].setValeur(true);
		
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur)  {
		if (valeur <= 7 && valeur >= -8) 
			this.valeur = valeur;
	}
	

}
