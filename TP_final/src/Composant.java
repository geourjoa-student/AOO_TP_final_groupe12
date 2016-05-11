public interface Composant {
	

	public int getId();

	//Met à jour les ports de sorties 
	public void calculerSorties();

	//Retourne le nieme port d'entree ou de sortie
	public PortSortie getNiemePortSortie(int n);
	
	public PortEntree getNiemePortEntree(int n);
	
}