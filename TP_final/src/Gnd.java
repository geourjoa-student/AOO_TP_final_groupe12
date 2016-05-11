public class Gnd extends Generateur {
	@Override
	public void calculerSorties()
	{

	}

	public Gnd(int id) {
		portsSorties = new PortSortie[1];
		portsSorties[0].setValeur(false);
		this.id = id;
	}

}
