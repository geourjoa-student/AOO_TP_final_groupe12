package projet.port;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import projet.composant.Composant;

public class PortEntreeComposite extends PortEntree {

	/**
	 * Un composite doit connaitre les composants qui y sont connect�, car il
	 * donctionne comme un port d'entr�e et comme un port de sortie Ici cela
	 * repr�sente l'interface d'entr�es du composite
	 */
	private List<PortEntree> portsEntreeComposantsInternesConnectes;

	public PortEntreeComposite(Composant proprietaire, int id) {
		super(proprietaire, id);

		portsEntreeComposantsInternesConnectes = new ArrayList<PortEntree>();
	}

	/**
	 * @param pe
	 *            : Port d'entr�e du composant que l'on veux ajouter comme ayant
	 *            un de ses ports d'entr�es �tant � l'entr�e du composite
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
