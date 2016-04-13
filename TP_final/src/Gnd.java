public class Gnd extends Generateur {
	@Override
	public void calculerSorties()
	{

	}

	public Gnd() {
		portsSorties = new PortSortie[1];
		portsSorties[0].setValeur(false);
		id = Elementaire.getNbOccurence();
	}

}
