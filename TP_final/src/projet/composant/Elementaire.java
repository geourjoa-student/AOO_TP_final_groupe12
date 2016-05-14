package projet.composant;

import projet.port.PortEntree;
import projet.port.PortSortie;

public abstract class Elementaire implements Composant {

	protected int id;
	
	protected PortEntree[] portsEntrees;

	protected PortSortie[] portsSorties;

	public int getId()
	{
		return id;
	}

	public PortSortie getNiemePortSortie(int n) {
		return portsSorties[n];
	}

	@Override
	public PortEntree getNiemePortEntree(int n) {
		return portsEntrees[n];
	}
	
	public boolean portsTousConnectes(){
		return true;
	}
}