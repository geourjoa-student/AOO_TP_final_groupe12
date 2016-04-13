public abstract class Elementaire implements Composant {

	protected int id;

	protected PortEntree[] portsEntrees;

	protected PortSortie[] portsSorties;

	private static int nbOccurence = 0;

	protected static int getNbOccurence()
	{
		nbOccurence++;
		return nbOccurence;
	}

	public int getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		String s = "<" + id + "| nomClasse (" + portsEntrees.length + "," + portsSorties.length + ")->";

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