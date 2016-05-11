public class Itr extends Generateur {

	private Boolean ferme;

	public Boolean estFerme()
	{
		return ferme;
	}

	public void changerEtat()
	{
		ferme = !ferme;
	}

	@Override
	public void calculerSorties()
	{
		this.portsSorties[0].setValeur(this.portsEntrees[0].isValeur() && !this.estFerme());
	}

	public Itr(int id){
		portsEntrees = new PortEntree[1];
		portsSorties = new PortSortie[1];
		ferme = true;
		this.id = id;
	}

	@Override
	public String toString()
	{
		//TODO: TESTER LA TERNACITE DE L'OPERATEUR
		String s = "<" + id + "| nomClasse (" + portsEntrees.length + "," + portsSorties.length + "){" + ((ferme)?"ferme":"ouvert") + "}->";

		for (int i = 0; i < portsEntrees.length; i++) 
		{
			s += "#" + portsSorties[i].getId_port();
			for (int j = 0; j < portsEntrees.length; j++) 
			{
				s += portsEntrees[i].getProprietairePort().getId() + "#" + portsEntrees[i].getId_port() + ",";
			}
		}

		s += ">";

		return s;
	}
}