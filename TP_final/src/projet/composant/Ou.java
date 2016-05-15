package projet.composant;

import java.util.Iterator;

import projet.port.PortEntree;
import projet.port.PortSortie;

public class Ou extends Transformateur {

	@Override
	public void calculerSorties() 
	{
		this.portsSorties[0].setValeur(this.portsEntrees[0].isValeur() || this.portsEntrees[1].isValeur());
		portsSorties[0].propagerValeur();
	}
	
	public Ou (int id){
		
		nbPortsEntree=2;
		nbPortsSortie=1;
		portsEntrees = new PortEntree[nbPortsEntree];
		portsSorties = new PortSortie[nbPortsSortie];
		
		portsEntrees[0] = new PortEntree(this, 0);
		portsEntrees[1] = new PortEntree(this, 1);

		portsSorties[0] = new PortSortie(this, 0);
		
		this.id = id;
	}

	@Override
	public String toString()
	{
		

		String s = "<" + id + "| Ou (" +  portsEntrees.length + "," +  portsSorties.length + ") -> ";

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