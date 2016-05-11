public interface Composant {
	
	public int getId();

	public void calculerSorties();

	public PortSortie getNiemePortSortie(int n);
	
	public PortEntree getNiemePortEntree(int n);
	
	public void definirPortEntreeComposant(PortEntree pe, int numeroPort);
	
	public void definirPortSortieComposant(PortSortie ps, int numeroPort);
	
}