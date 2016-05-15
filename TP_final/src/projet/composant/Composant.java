package projet.composant;
import projet.exception.PortInconnuException;
import projet.port.PortEntree;
import projet.port.PortSortie;

public interface Composant {
	

	public int getId();

	//Met à jour les ports de sorties 
	public void calculerSorties();

	//Retourne le nieme port d'entree ou de sortie
	public PortSortie getNiemePortSortie(int n) throws PortInconnuException;
	
	public PortEntree getNiemePortEntree(int n) throws PortInconnuException;
	
	public boolean portsTousConnectes();
	
}