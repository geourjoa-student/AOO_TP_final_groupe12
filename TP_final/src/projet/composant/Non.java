package projet.composant;
import java.util.Iterator;

import projet.port.PortEntree;
import projet.port.PortSortie;

public class Non extends Transformateur {

		
	
	public Non(int id) {
		portsEntrees = new PortEntree[1];
		portsEntrees[0] = new PortEntree(this,0);
		portsSorties = new PortSortie[1];
		portsSorties[0] = new PortSortie(this,0);
		this.id = id;
	}
	
	@Override
	public void calculerSorties() {
		
		this.portsSorties[0].setValeur(!this.portsEntrees[0].isValeur());
		portsSorties[0].propagerValeur();
		
	}
	
	@Override
	public String toString()
	{
		//String s = "<" + id + "| nomClasse (" + portsEntrees.length + "," + portsSorties.length + ")->";

		String s = "<" + id + "| Non (" +  1 + "," + 1 + ") -> ";

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