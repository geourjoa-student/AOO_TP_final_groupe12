package projet.composant;

import projet.composant.Circuit;
import projet.port.PortEntree;
import projet.port.PortSortie;

public class Composite extends Circuit implements Composant{

	private int id;
	
	private int profondeur;

	public PortEntree[] portsEntrees;

	public PortSortie[] portsSorties;

	public Composite(String nomComposant, int id, int nbPortsEntree, int nbPortsSortie) {
		super(nomComposant);

		portsEntrees = new PortEntree[nbPortsEntree];
		portsSorties = new PortSortie[nbPortsSortie];
		
		this.id = id;
		
		for (int i = 0; i < portsEntrees.length; i++) {
			portsEntrees[i]=new PortEntree(this, i);
			
		}
	}

	public void definirPortEntreeComposant(int idComposant, int numeroPortComposant, int numeroPortComposite) {
		//TODO verif
		portsEntrees[numeroPortComposite]=composants.get(idComposant).getNiemePortEntree(numeroPortComposant);
	}

	public void definirPortSortieComposant(int idComposant, int numeroPortComposant, int numeroPortComposite) {
		//TODO verif
		portsSorties[numeroPortComposite]=composants.get(idComposant).getNiemePortSortie(numeroPortComposant);
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void calculerSorties() {
		execute();
		
	}

	@Override
	public PortSortie getNiemePortSortie(int n) {
		//TODO verif
		return portsSorties[n];
	}

	@Override
	public PortEntree getNiemePortEntree(int n) {
		//TODO verif
		return portsEntrees[n];
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}

	
}