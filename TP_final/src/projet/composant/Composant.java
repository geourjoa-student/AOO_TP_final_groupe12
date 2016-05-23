package projet.composant;

import projet.exception.PortInconnuException;
import projet.port.PortEntree;
import projet.port.PortSortie;

/**
 * @author anthony Interface permettant de définir le comportement d'un
 *         composant de circuit, qu'il s'agisse d'une porte élémentaire ou un
 *         composite
 */
public interface Composant {

	public int getId();

	/**
	 * Mise à jour du composant en fonction de ses entrées
	 */
	public void calculerSorties();

	/**
	 * @param n
	 *            : numéro de port désiré
	 * @return le port demandé
	 * @throws PortInconnuException
	 *             : si le port est inconnu
	 * 
	 *             Accesseur sur le nieme port de sortie d'un composant
	 */
	public PortSortie getNiemePortSortie(int n) throws PortInconnuException;

	/**
	 * @param n
	 *            : numéro de port désiré
	 * @return le port demandé
	 * @throws PortInconnuException
	 *             : si le port est inconnu
	 * 
	 *             Accesseur sur le nieme port d'entrée d'un composant
	 */
	public PortEntree getNiemePortEntree(int n) throws PortInconnuException;

	/**
	 * @return true si tous ports du composant sont cablés, false sinon
	 */
	public boolean portsTousConnectes();

	/**
	 * @return le nombre de ports de sorties du composant
	 */
	public int getNbPortsSorties();

	/**
	 * @return le nombre de ports d'entrées du composant
	 */
	public int getNbPortsEntrees();
}