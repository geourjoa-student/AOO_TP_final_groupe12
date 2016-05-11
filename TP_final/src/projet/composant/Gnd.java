package projet.composant;
import projet.port.PortSortie;

public class Gnd extends Generateur {
	@Override
	public void calculerSorties()
	{
		portsSorties[0].propagerValeur();
	}

	public Gnd(int id) {
		portsSorties = new PortSortie[1];
		portsSorties[0] = new PortSortie(this,0);
		portsSorties[0].setValeur(false);
		this.id = id;
	}

}
