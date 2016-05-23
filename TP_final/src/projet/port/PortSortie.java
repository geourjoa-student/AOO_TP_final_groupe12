package projet.port;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import projet.composant.Composant;

public class PortSortie extends Port {

	/**
	 * C'est PortSortie qui sait � quels ports d'entr�es il est connect�.
	 */
	private List<PortEntree> portsConnectes;

	/**
	 * @param proprietaire
	 *            : COmme pour un port g�n�rique
	 * @param id
	 *            : De m�me
	 */
	public PortSortie(Composant proprietaire, int id) {
		id_port = id;
		portsConnectes = new ArrayList<PortEntree>();
		this.proprietairePort = proprietaire;
	}

	public List<PortEntree> getListePortEntreeConnectes()
	{
		return portsConnectes;
	}

	/**
	 * @param p
	 *            : Port d'entr�e reli� � ce port de sortie On veut donc
	 *            l'ajouter � la liste portsConnectes
	 */
	public void ajouterConnexion(PortEntree p)
	{
		portsConnectes.add(p);
		p.connecte();

	}

	/**
	 * Permet de propager sa valeur aux ports d'entr�es connect�s L'info entre
	 * dans un composant par le port d'entr�e Le composant calcule les sorties,
	 * la nouvelle valeur est enregistr�e dans le port de sortie Puis le port de
	 * sortie la propage aux ports connect�s, permettant une transmission de
	 * proche en proche
	 */
	public void propagerValeur()
	{

		for (Iterator<PortEntree> it = portsConnectes.iterator(); it.hasNext();) {
			PortEntree portEntreeCourant = it.next();
			portEntreeCourant.setValeur(valeur);

		}

	}

	@Override
	public boolean estConnecte()
	{
		return (portsConnectes.size() > 0);
	}

}