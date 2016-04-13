public class Non extends Transformateur {

	@Override
	public void calculerSorties() {
		
		this.portsSorties[0].setValeur(!this.portsEntrees[0].isValeur());
		
	}
}