
import java.util.List;



public abstract class Elementaire implements Composant{
	
	private int id;

	protected List<PortEntree> portsEntrees;

	protected List<PortSortie> portsSorties;
	
	public int getId () {
		return id;
	}

	@Override
	public String toString() {
		String s = "<" + id + "| nomClasse (" + portsEntrees.size() + "," + portsSorties.size() + ")->" ;
		
		for (PortSortie portCourant : portsSorties) {
					
			s += "#" + portCourant.getId_port();
			
			for (PortEntree portEntreeCourant : portCourant.getListePortEntreeConnectes()) {			
				s+= portEntreeCourant.getProprietairePort().getId() + "#" + portEntreeCourant.getId_port() +",";					 	
			}
		}
		
		s += ">";
				
		return s;
	}
	
	

}