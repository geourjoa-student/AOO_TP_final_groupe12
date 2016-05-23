package projet.port;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import projet.composant.Composant;

public class PortSortie extends Port {

	/**
	 * C'est PortSortie qui sait à quels ports d'entrées il est connecté.
	 */
	private List<PortEntree> portsConnectes;

	/**
	 * @param proprietaire
	 *            : COmme pour un port générique
	 * @param id
	 *            : De même
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
	 *            : Port d'entrée relié à ce port de sortie On veut donc
	 *            l'ajouter à la liste portsConnectes
	 */
	public void ajouterConnexion(PortEntree p)
	{
		portsConnectes.add(p);
		p.connecte();

	}

	/**
	 * Permet de propager sa valeur aux ports d'entrées connectés L'info entre
	 * dans un composant par le port d'entrée Le composant calcule les sorties,
	 * la nouvelle valeur est enregistrée dans le port de sortie Puis le port de
	 * sortie la propage aux ports connectés, permettant une transmission de
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