import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Circuit {
	
	private String nomCircuit;

	public List<Composant> composants;

	public Circuit(String nomCircuit) {
		this.nomCircuit = nomCircuit;
		
		this.composants = new ArrayList<Composant>();
		
	}

	public void ajouterComposant(Composant c) {
	}

	@Override
	public String toString() {
		String s = nomCircuit + "[\n"; 
		
		for (Composant composantCourant : composants) {
			
		}
		return s;
	}
	
	

}