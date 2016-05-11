package projet.composant;
import java.util.Iterator;

import projet.port.PortEntree;
import projet.port.PortSortie;

public class Gnd extends Generateur {
	@Override
	public void calculerSorties()
	{
		portsSorties[0].propagerValeur();
	}

	public Gnd(int id) {
		portsSorties = new PortSortie[1];
		portsSorties[0] = new PortSortie(this,0);
		portsSorties[0].setValeur(false);
		this.id = id;
	}
	
	@Override
	public String toString()
	{
		//String s = "<" + id + "| nomClasse (" + portsEntrees.length + "," + portsSorties.length + ")->";

		String s = "<" + id + "| Gnd (" +  0 + "," +  portsSorties.length + ") -> ";

		for (int i = 0; i < portsSorties.length; i++) 
		{
			s += "#" + portsSorties[i].getId_port() +"(";
					
			for (Iterator<PortEntree> it = portsSorties[i].getListePortEntreeConnectes().iterator(); it.hasNext();) {
				PortEntree pe = it.next();
				s+=  pe.getProprietairePort().getId() + "#" + pe.getId_port() + ",";				
			}		
			s+=")";	
		}

		s += ">";

		return s;
	}

}
