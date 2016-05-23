package projet.port;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import projet.composant.Composant;

public class PortEntreeComposite extends PortEntree {

	/**
	 * Un composite doit connaitre les composants qui y sont connecté, car il
	 * donctionne comme un port d'entrée et comme un port de sortie Ici cela
	 * représente l'interface d'entrées du composite
	 */
	private List<PortEntree> portsEntreeComposantsInternesConnectes;

	public PortEntreeComposite(Composant proprietaire, int id) {
		super(proprietaire, id);

		portsEntreeComposantsInternesConnectes = new ArrayList<PortEntree>();
	}

	/**
	 * @param pe
	 *            : Port d'entrée du composant que l'on veux ajouter comme ayant
	 *            un de ses ports d'entrées étant à l'entrée du composite
	 */
	public void ajouterPortEntreeComposantInterne(PortEntree pe)
	{
		portsEntreeComposantsInternesConnectes.add(pe);
	}

	public void setValeur(boolean valeur)
	{
		this.valeur = valeur;

		for (Iterator<PortEntree> iterator = portsEntreeComposantsInternesConnectes.iterator(); iterator.hasNext();) {
			PortEntree pe = (PortEntree) iterator.next();

			pe.setValeur(valeur);
		}
	}

	public List<PortEntree> getPortsEntreeComposantsInternesConnectes()
	{
		return portsEntreeComposantsInternesConnectes;
	}

}
