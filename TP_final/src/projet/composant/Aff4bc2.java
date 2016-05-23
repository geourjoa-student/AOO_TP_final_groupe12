package projet.composant;

import projet.port.PortEntree;

/**
 * @author anthony
 * 
 *         Répresente un afficheur 4 bits en complément à 2. L'étendue
 *         d'affichage est de de -8 à +7. Le port d'entrée 3 représente le poids
 *         faible
 *
 */
public class Aff4bc2 extends Recepteur {

	private int valeur;

	/**
	 * @param id
	 *            id de l'afficheur crée
	 */
	public Aff4bc2(int id) {
		nbPortsEntree = 4;
		nbPortsSortie = 0;

		portsEntrees = new PortEntree[nbPortsEntree];

		for (int i = 0; i < nbPortsEntree; i++) {
			portsEntrees[i] = new PortEntree(this, i);
		}

		this.id = id;
	}

	@Override
	public void calculerSorties() {
		int valeurTemporaire = 0;

		if (portsEntrees[0].isValeur())
			valeurTemporaire++;
		if (portsEntrees[1].isValeur())
			valeurTemporaire += 2;
		if (portsEntrees[2].isValeur())
			valeurTemporaire += 4;
		if (portsEntrees[3].isValeur())
			valeurTemporaire = ~valeurTemporaire;
		valeurTemporaire++;

		valeur = valeurTemporaire;

	}

	public int getValeur() {
		return valeur;
	}

	@Override
	public String toString() {

		String s = "<" + id + "| Aff4bc2 (" + portsEntrees.length + "," + 0 + "){" + valeur + "} > ";

		return s;
	}
}
