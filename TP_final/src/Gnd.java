public class Gnd extends Generateur {
	@Override
	public void calculerSorties()
	{

	}

	public Gnd() {
		portsSorties = new PortSortie[1];
		portsSorties[0].setValeur(true);
		id = Elementaire.getNbOccurence();
	}

}
