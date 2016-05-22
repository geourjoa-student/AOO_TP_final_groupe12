package projet.composant;

import projet.port.PortEntree;
import projet.port.PortSortie;

public class Aff4bc2 extends Recepteur {
	
	private int valeur;
	
	public Aff4bc2(int id) {
		nbPortsEntree=1;
		nbPortsSortie=0;
		
		portsEntrees= new PortEntree[nbPortsSortie];
		
		for (int i = 0; i < nbPortsEntree; i++) {
			portsEntrees[i] = new PortEntree(this,i);
		}
		
		this.id=id;
	}

	@Override
	public void calculerSorties() {
		int valeurTemporaire=0;
		
		if(portsEntrees[0].isValeur())
			valeurTemporaire++;
		if(portsEntrees[1].isValeur())
			valeurTemporaire+=2;
		if(portsEntrees[2].isValeur())
			valeurTemporaire+=4;
		if(portsEntrees[1].isValeur())
			valeurTemporaire=~valeurTemporaire;
			valeurTemporaire++;
			
		valeur=valeurTemporaire;
		
	}

	public int getValeur() {
		return valeur;
	}
	
	@Override
	public String toString() {
	
		String s = "<" + id + "| Aff4bc2 (" + portsEntrees.length + "," + 0 + "){"
				+ valeur + "} > ";

		return s;
	}
}
