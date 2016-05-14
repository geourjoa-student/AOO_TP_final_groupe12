package projet.composant;
import java.util.Iterator;

import projet.port.PortEntree;
import projet.port.PortSortie;

public abstract class Elementaire implements Composant {

	protected int id;
	
	protected PortEntree[] portsEntrees;

	protected PortSortie[] portsSorties;
	
	protected int profondeur;

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
	
	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}
	
	public boolean portsTousConnectes(){
		return true;
	}
}