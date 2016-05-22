package projet.composant;

import java.util.Iterator;

import projet.port.PortEntree;
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
	
	@Override
	public String toString()
	{

		String s = "<" + id + "| Itr (" + 0 + "," + portsSorties.length + "){" + valeur + "}->";

		for (int i = 0; i < portsSorties.length; i++) 
		{
			s += "#" + portsSorties[i].getId_port() +"(";
					
			for (Iterator<PortEntree> it = portsSorties[i].getListePortEntreeConnectes().iterator(); it.hasNext();) {
				PortEntree pe = it.next();
				s+=  pe.getProprietairePort().getId() + "#" + pe.getId_port(); 
				
				if(it.hasNext()){
					s+= ",";
				}
			}		
			s+=")";	
		}

		s += ">";

		return s;
	}
	

}
