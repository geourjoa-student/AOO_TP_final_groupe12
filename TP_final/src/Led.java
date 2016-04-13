public class Led extends Recepteur {

  public Boolean allume;

  public Boolean estAllume() {
  return allume;
  }

	@Override
	public void calculerSorties()
	{
		allume = this.portsEntrees[0].isValeur();
		this.portsSorties[0].setValeur(this.portsEntrees[0].isValeur());
	}

	public Led() {
		portsEntrees = new PortEntree[1];
		portsSorties = new PortSortie[1];
		id = Elementaire.getNbOccurence();
	}

	@Override
	public String toString()
	{
		//TODO: TESTER LA TERNACITE DE L'OPERATEUR
		String s = "<" + id + "| nomClasse (" + portsEntrees.length + "," + portsSorties.length + "){" + ((allume)?"allume":"eteint") + "}->";

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