package projet.port;

import projet.composant.Composant;

public abstract class Port {

	/**
	 * Valeur du port, permet de la propager notamment
	 */
	protected boolean valeur;

	protected Integer id_port;

	protected Composant proprietairePort;

	public Integer getId_port()
	{
		return id_port;
	}

	/**
	 * @return proprietairePort : Composant possédant ce port Utile pour les
	 *         méthodes qui ont besoin de remonter vers ke composant
	 *         propriétaire
	 */
	public Composant getProprietairePort()
	{
		return proprietairePort;
	}

	public boolean isValeur()
	{
		return valeur;
	}

	public void setValeur(boolean valeur)
	{
		this.valeur = valeur;
	}

	public abstract boolean estConnecte();

}