package projet.composant;

import projet.port.PortEntree;
import projet.port.PortSortie;

public abstract class Elementaire implements Composant {

	protected int id;
	
	protected PortEntree[] portsEntrees;

	protected PortSortie[] portsSorties;
	
	protected int nbPortsSortie;
	
	protected int nbPortsEntree;

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
		for (int i = 0; i < nbPortsEntree; i++) {
			if(!portsEntrees[i].estConnecte())
				return false;		
		}
		
		for (int i = 0; i < nbPortsSortie; i++) {
			if(!portsSorties[i].estConnecte())
				return false;		
		}
		
		return true;
	}
}