public class Vcc extends Generateur {
	@Override
	public void calculerSorties()
	{

	}

	public Vcc() {
		portsSorties = new PortSortie[1];
		portsSorties[0].setValeur(true);
		id = Elementaire.getNbOccurence();
	}

}