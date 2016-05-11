
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
}