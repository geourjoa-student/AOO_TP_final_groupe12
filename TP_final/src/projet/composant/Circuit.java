package projet.composant;
import java.util.HashMap;
import java.util.Map;

public class Circuit {

	protected String nomCircuit;

	protected Map<Integer, Composant> composants;

	public Circuit(String nomCircuit) {
		this.nomCircuit = nomCircuit;

		this.composants = new HashMap<Integer, Composant>();
		
	}

	public void ajouterComposant(Composant c) {
		composants.put(c.getId(), c);
	}

	public void cabler(int idComposantPortSortie, int numeroPortSortie, int idComposantPortEntree,
			int numeroPortEntre) {

		Composant cs = (Composant) composants.get(idComposantPortSortie);
		Composant ce = (Composant) composants.get(idComposantPortEntree);

		cs.getNiemePortSortie(numeroPortSortie).ajouterConnexion(ce.getNiemePortEntree(numeroPortEntre));

	}

	public void execute() throws Exception {
		
		//TODO	Ajouter système require
		if(this instanceof Circuit)
			if (!estComplet())
				throw new Exception();

		// La première boucle permet aux portes de se stabiliser quelque soit
		// l'ordre des execute
		for (int i = 0; i < composants.size(); i++) {
			for (Composant c : composants.values()) {
				c.calculerSorties();
			}
		}

	}
	
	private boolean estComplet(){
		
		boolean complet = true;
		
		for (Composant c : composants.values()) {
			complet &= c.portsTousConnectes();
		}
		
		return complet;
	}

	@Override
	public String toString() {

		String s = nomCircuit + "[\n";

		for (Composant c : composants.values()) {
			s += "\t" + c + "\n";
		}
		
		

		s += "]\n\n";
		
		if(estComplet())
			s+= "Le circuit est complet.\n";
		else
			s+= "Le circuit n'est pas complet.\n";	
		
		return s;
	}

}