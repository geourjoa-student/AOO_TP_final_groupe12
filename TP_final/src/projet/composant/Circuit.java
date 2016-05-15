package projet.composant;
import java.util.HashMap;
import java.util.Map;

import projet.exception.ActionInterditeException;
import projet.exception.CircuitNonCompletException;
import projet.exception.ComposantInconnuException;
import projet.exception.PortInconnuException;

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
			int numeroPortEntre) throws ComposantInconnuException, PortInconnuException {
		
		if(!composants.containsKey(idComposantPortEntree)||!composants.containsKey(idComposantPortSortie)){
			throw new ComposantInconnuException();
		}

		Composant cs = (Composant) composants.get(idComposantPortSortie);
		Composant ce = (Composant) composants.get(idComposantPortEntree);

		cs.getNiemePortSortie(numeroPortSortie).ajouterConnexion(ce.getNiemePortEntree(numeroPortEntre));

	}

	public void execute() throws CircuitNonCompletException {
		
		//TODO	Ajouter système require
		
		if (!estComplet())
			throw new CircuitNonCompletException();
		
		// La première boucle permet aux portes de se stabiliser quelque soit
		// l'ordre des execute
		for (int i = 0; i < composants.size(); i++) {
			for (Composant c : composants.values()) {
				c.calculerSorties();
			}
		}

	}
	
	protected boolean estComplet(){
		
	
		for (Composant c : composants.values()) {
			if(!c.portsTousConnectes())
				return false;
		}
		
		return true;
	}
	
	public void changerItr(int idItr) throws ComposantInconnuException, ActionInterditeException{
		
		if(composants.containsKey(idItr))
			throw new ComposantInconnuException();
		
		if(!(composants.get(idItr) instanceof Itr)){
			throw new ActionInterditeException();
		}
		
		((Itr) composants.get(idItr)).changerEtat();
		
	}
	
	public boolean observerLed(int idLed)throws ComposantInconnuException, ActionInterditeException{
		if(composants.containsKey(idLed))
			throw new ComposantInconnuException();
		
		if(!(composants.get(idLed) instanceof Itr)){
			throw new ActionInterditeException();
		}
		
		return ((Led) composants.get(idLed)).estAllume();
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