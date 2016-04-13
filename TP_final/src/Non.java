public class Non extends Transformateur {

	@Override
	public void calculerSorties() {
		
		this.portsSorties.get(0).setValeur(!this.portsEntrees.get(0).isValeur());
		
	}


}