package projet.composant;

import java.util.Iterator;

import projet.port.PortEntree;
import projet.port.PortSortie;

public class Gen4bc2 extends Generateur{
	
	private int valeur;
	
	
	public Gen4bc2(int id) {
		nbPortsEntree=0;
		nbPortsSortie=4;

		portsSorties = new PortSortie[nbPortsSortie];
		
		for (int i = 0; i < portsSorties.length; i++) {	
			portsSorties[i] = new PortSortie(this,0);				
		}
		
		setValeur() = 0;

		this.id = id;
	}

	@Override
	public String toString()
	{
		//String s = "<" + id + "| nomClasse (" + portsEntrees.length + "," + portsSorties.length + ")->";

		String s = "<" + id + "| Gen4bc2 (" +  0 + "," +  portsSorties.length + "){" + getValeur() + "} -> ";

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

	@Override
	public void calculerSorties() {
		
		
	}

}
