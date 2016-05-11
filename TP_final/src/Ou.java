import java.util.Iterator;

public class Ou extends Transformateur {

	@Override
	public void calculerSorties() 
	{
		this.portsSorties[0].setValeur(this.portsEntrees[0].isValeur() || this.portsEntrees[1].isValeur());
	}
	
	public Ou (int id){
	
		portsEntrees = new PortEntree[2];
		portsSorties = new PortSortie[1];
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
				s+=  pe.getProprietairePort().getId() + "#" + pe.getId_port() + ",";				
			}		
			s+=")";			
		}

		s += ">";

		return s;
	}
}