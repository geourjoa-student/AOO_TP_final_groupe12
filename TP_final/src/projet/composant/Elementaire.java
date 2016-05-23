package projet.composant;

import projet.exception.PortInconnuException;
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
	
	public int getLengthSorties(){
		return portsSorties.length;
	}
	
	public int getLengthEntrees(){
		return portsEntrees.length;
	}

	public PortSortie getNiemePortSortie(int n) throws PortInconnuException{
		if(n>=nbPortsSortie)
			throw new PortInconnuException();
		return portsSorties[n];
	}

	@Override
	public PortEntree getNiemePortEntree(int n) throws PortInconnuException{
		if(n>=nbPortsEntree)
			throw new PortInconnuException();
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