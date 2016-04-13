public class Ou extends Transformateur {

	@Override
	public void calculerSorties() 
	{
		this.portsSorties[0].setValeur(this.portsEntrees[0].isValeur() || this.portsEntrees[1].isValeur());
	}
	
	public Ou()
	{
		portsEntrees = new PortEntree[2];
		portsSorties = new PortSortie[1];
	    id = Elementaire.getNbOccurence();
	}
	
	
}