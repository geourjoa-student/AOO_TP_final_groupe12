package projet.composant;

import java.util.HashMap;
import java.util.Map;

import projet.exception.ActionInterditeException;
import projet.exception.CircuitNonCompletException;
import projet.exception.ComposantInconnuException;
import projet.exception.PortInconnuException;

/**
 * @author anthony
 *
 *         Répresente un circuit fermé de composant en intéraction. Le circuit
 *         est executable, c'est à dire que l'on peut mettre à jour les
 *         Recepteur en fonctions des générateurs.
 */
public class Circuit {

	protected String nomCircuit;

	/**
	 * Liste des composants du circuit. Stockage dans une map en clé/valeur ou
	 * l'id du composant est la clé et la valeur, le composant lui même.
	 */
	protected Map<Integer, Composant> composants;

	public Circuit(String nomCircuit) {
		this.nomCircuit = nomCircuit;
		this.composants = new HashMap<Integer, Composant>();

	}

	public String getNom() {
		return nomCircuit;
	}

	public void ajouterComposant(Composant c) {
		composants.put(c.getId(), c);
	}

	public Map<Integer, Composant> getComposants() {
		return composants;
	}

	/**
	 * @param idComposantPortSortie
	 *            : premier composant à connecter (il fournit l'information)
	 * @param numeroPortSortie
	 *            : id du port à connecter du composant
	 * @param idComposantPortEntree
	 *            : second composant à connecter (il reçoit l'information)
	 * @param numeroPortEntre
	 *            : id du port à connecter du composant 1
	 * @throws ComposantInconnuException
	 *             : Si un composant demandé n'existe pas
	 * @throws PortInconnuException
	 *             : Si un port n'existe pas
	 * 
	 *             Cablage du circuit
	 */
	public void cabler(int idComposantPortSortie, int numeroPortSortie, int idComposantPortEntree, int numeroPortEntre)
			throws ComposantInconnuException, PortInconnuException {

		if (!composants.containsKey(idComposantPortEntree) || !composants.containsKey(idComposantPortSortie)) {
			throw new ComposantInconnuException();
		}

		Composant cs = (Composant) composants.get(idComposantPortSortie);
		Composant ce = (Composant) composants.get(idComposantPortEntree);

		cs.getNiemePortSortie(numeroPortSortie).ajouterConnexion(ce.getNiemePortEntree(numeroPortEntre));

	}

	/**
	 * @throws CircuitNonCompletException
	 * 
	 *             Execution du circuit (mise à jour des récepteurs en fonctions
	 *             des autres composants)
	 */
	public void execute() throws CircuitNonCompletException {

		if (!estComplet())
			throw new CircuitNonCompletException();

		// La première boucle permet aux portes de se stabiliser quel que soit
		// l'ordre des composants executés
		for (int i = 0; i < composants.size(); i++) {
			for (Composant c : composants.values()) {
				c.calculerSorties();
			}
		}

	}

	/**
	 * @return true si le circuit est complet (tous les ports possèdent au moins
	 *         une connection), false sinon
	 */
	protected boolean estComplet() {

		for (Composant c : composants.values()) {
			if (!c.portsTousConnectes())
				return false;
		}

		return true;
	}

	/**
	 * @param idItr
	 *            : id de l'Itr à actionner
	 * @throws ComposantInconnuException
	 *             : jeter si le composant est introuvable
	 * @throws ActionInterditeException
	 *             : jeter si l'id ne correcpond pas à un Itr
	 * 
	 *             Agir sur un Itr
	 */
	public void changerItr(int idItr) throws ComposantInconnuException, ActionInterditeException {
		// TODO La méthode peut être améliorée. Il n'est possible d'agir que sur
		// les Itr directement sur le circuit et pas ceux à l'intérieur d'un
		// composite
		if (!composants.containsKey(idItr))
			throw new ComposantInconnuException();

		if (!(composants.get(idItr) instanceof Itr)) {
			throw new ActionInterditeException();
		}

		((Itr) composants.get(idItr)).changerEtat();

	}

	public boolean observerItr(int idItr) throws ComposantInconnuException, ActionInterditeException {
		// TODO La méthode peut être améliorée. Il n'est possible d'obserever
		// que les Itr directement sur le circuit et pas ceux à l'intérieur d'un
		// composite
		if (!composants.containsKey(idItr))
			throw new ComposantInconnuException();

		if (!(composants.get(idItr) instanceof Itr)) {
			throw new ActionInterditeException();
		}

		return ((Itr) composants.get(idItr)).getEtat();

	}

	public boolean observerLed(int idLed) throws ComposantInconnuException, ActionInterditeException {

		// TODO La méthode peut être améliorée. Il n'est possible d'obserever
		// que les Leds directement sur le circuit et pas ceux à l'intérieur
		// d'un composite
		if (!composants.containsKey(idLed))
			throw new ComposantInconnuException();

		if (!(composants.get(idLed) instanceof Led)) {
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

		if (estComplet())
			s += "Le circuit est complet.\n";
		else
			s += "Le circuit n'est pas complet.\n";

		return s;
	}

}