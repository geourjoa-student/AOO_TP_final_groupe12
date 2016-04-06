
import java.util.List;



public abstract class Elementaire implements Composant{
	
	private int id;

	private List<PortEntree> portsEntrees;

	private List<PortSortie> portsSorties;
	
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