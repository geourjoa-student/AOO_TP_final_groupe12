package projet.port;

import projet.composant.Composant;

public class PortEntree extends Port {

	/**
	 * C'est juste un boolean, Un port d'entr�e ne sait pas � qui il est
	 * connect�!
	 */
	private boolean composantConnecte;

	/**
	 * @param proprietaire
	 *            : Mais il connait son propri�taire
	 * @param id
	 *            : Id dans le composant
	 */
	public PortEntree(Composant proprietaire, int id) {
		this.id_port = id;

		this.proprietairePort = proprietaire;
		this.composantConnecte = false;
	}

	@Override
	public boolean estConnecte()
	{
		return composantConnecte;
	}

	public void connecte()
	{
		composantConnecte = true;

	}

}