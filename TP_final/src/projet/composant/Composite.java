package projet.composant;

import java.util.Iterator;

import projet.composant.Circuit;
import projet.exception.PortInconnuException;
import projet.port.PortEntree;
import projet.port.PortEntreeComposite;
import projet.port.PortSortie;

/**
 * @author anthony
 * 
 *         Composant élaboré à partir d'autres composant. Son fonctionnement
 *         rappelle celui d'un circuit (gestion des composants le contenant) ->
 *         héritage de circuit et le comportement d'un composant classique ->
 *         implémentation de Composant
 */
public class Composite extends Circuit implements Composant {

	private int id;

	/**
	 * Utilisé pour l'affichage console (nb tabulation dans le cas d'emboitement
	 * de composite)
	 */
	private int profondeur;

	/**
	 * Tableau des ports d'entrée et de sortiues du composite. Les
	 * communications avec les autres composants sont uniquement faites à partir
	 * de ces 2 tableaux
	 */
	private PortEntreeComposite[] portsEntrees;
	private PortSortie[] portsSorties;

	public Composite(String nomComposant, int id, int nbPortsEntree, int nbPortsSortie, int profondeur) {
		super(nomComposant);

		portsEntrees = new PortEntreeComposite[nbPortsEntree];
		portsSorties = new PortSortie[nbPortsSortie];

		this.profondeur = profondeur;

		this.id = id;

		for (int i = 0; i < portsEntrees.length; i++) {
			portsEntrees[i] = new PortEntreeComposite(this, i);

		}
	}

	/**
	 * @param idComposant
	 *            : composant interne à lier à l'entrée du composite
	 * @param numeroPortComposant
	 *            : numéro à connecter
	 * @param numeroPortComposite
	 *            : numéro du port concerné du composite
	 * @throws PortInconnuException
	 *             : jeter si l'un des ports est inexistant
	 * 
	 *             Etablissement de la connexion entre l'entrée d'un compoant
	 *             interne au composite et une entrée effective du composite
	 *             Problème rencontré une entrée donnée d'un composite peut-être
	 *             réutilisé à plusieurs endroits, un ou exclusif par exemple.
	 *             Remarque, un port d'entrée ne peut être connecté qu'à un seul
	 *             port de sortie. Ici les ports d'entrée du composite sont un
	 *             peu différents. Ils héritent de portEntrée (pour être vu
	 *             comme tel depuis l'extérieur) mais en interne des composants
	 *             d'entrée peuvent si brancher.
	 */
	public void connecterPortEntreeComposant(int idComposant, int numeroPortComposant, int numeroPortComposite)
			throws PortInconnuException {

		portsEntrees[numeroPortComposite]
				.ajouterPortEntreeComposantInterne(composants.get(idComposant).getNiemePortEntree(numeroPortComposant));
		composants.get(idComposant).getNiemePortEntree(numeroPortComposant).connecte();

		portsEntrees[numeroPortComposite].connecte();
	}

	/**
	 * @param idComposant
	 *            : composant interne concerné
	 * @param numeroPortComposant
	 *            : numéro du port concerné
	 * @param numeroPortComposite
	 *            : numéro du port concerné du composite
	 * @throws PortInconnuException
	 *             : jeter si l'un des ports est inexistant
	 */
	public void definirPortSortieComposant(int idComposant, int numeroPortComposant, int numeroPortComposite)
			throws PortInconnuException {
		// TODO verif
		portsSorties[numeroPortComposite] = composants.get(idComposant).getNiemePortSortie(numeroPortComposant);
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void calculerSorties() {

		try {
			execute();
		} catch (Exception e) {
			// TODO Normalement cette exception est impossible
			e.printStackTrace();
		}

	}
	
	@Override
	public int getNbPortsSorties() {
		return portsSorties.length;
	}

	@Override
	public int getNbPortsEntrees() {
		return portsEntrees.length;
	}

	@Override
	public PortSortie getNiemePortSortie(int n) throws PortInconnuException {
		if (n >= portsSorties.length)
			throw new PortInconnuException();
		return portsSorties[n];
	}

	@Override
	public PortEntree getNiemePortEntree(int n) throws PortInconnuException {

		if (n >= portsEntrees.length)
			throw new PortInconnuException();
		return portsEntrees[n];
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}

	@Override
	public boolean portsTousConnectes() {

		for (int i = 0; i < portsEntrees.length; i++) {
			if (!portsEntrees[i].estConnecte())
				return false;
		}

		for (int i = 0; i < portsSorties.length; i++) {
			if (portsSorties[i] == null)
				return false;
		}

		return estComplet();
	}

	@Override
	public String toString() {

		String s = "<" + id + "| " + nomCircuit + " (" + portsEntrees.length + "," + portsSorties.length + ")[";

		for (int i = 0; i < portsEntrees.length; i++) {
			s += "#" + i + "(";

			for (Iterator<PortEntree> iterator = portsEntrees[i].getPortsEntreeComposantsInternesConnectes()
					.iterator(); iterator.hasNext();) {
				PortEntree pe = (PortEntree) iterator.next();

				s += pe.getProprietairePort().getId() + "#" + pe.getId_port();

				if (iterator.hasNext()) {
					s += ",";
				}

			}

			s += ")";

			if (i < portsEntrees.length - 1) {
				s += ",";
			}
		}

		s += "\n";

		for (Composant c : composants.values()) {

			for (int i = 0; i <= profondeur; i++) {
				s += "\t";
			}

			s += c + "\n";
		}

		for (int i = 0; i < profondeur; i++) {
			s += "\t";
		}

		s += "]-> ";

		for (int i = 0; i < portsSorties.length; i++) {
			s += "#" + portsSorties[i].getId_port() + "(";

			for (Iterator<PortEntree> it = portsSorties[i].getListePortEntreeConnectes().iterator(); it.hasNext();) {
				PortEntree pe = it.next();
				s += pe.getProprietairePort().getId() + "#" + pe.getId_port();

				if (it.hasNext()) {
					s += ",";
				}
			}
			s += ")";
		}

		s += ">";

		return s;
	}

}