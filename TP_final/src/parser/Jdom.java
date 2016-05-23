package parser;

import java.io.*;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import projet.composant.Circuit;
import projet.composant.Composant;
import projet.composant.Composite;
import projet.exception.PortInconnuException;


public class Jdom {

	static Element racine = new Element("Tout");

	static org.jdom2.Document document = new Document(racine);

	public void createDoc(Circuit c)
	{
		// On recupère le circuit, on va commencer par son nom
		Element circuit = new Element("Circuit");
		racine.addContent(circuit);
		Attribute nom = new Attribute("nom", c.getNom());
		circuit.setAttribute(nom);
		// Boucle pour parcourir tous les composants
		for (int i = 1; i <= c.getComposants().size(); i++) {
			Composant composantCourant = c.getComposants().get(i);
			System.out.println(composantCourant.getClass().getName());
			// Si on a un composite
			if (composantCourant instanceof Composite) {
				// Lancer la récursion sur composite
				funComposite1((Circuit) composantCourant);

			} else {

				// On a u composant on cherche ses attributs
				Element composant = new Element("Composant");
				circuit.addContent(composant);
				Attribute idf = new Attribute("idf", Integer.toString(composantCourant.getId()));
				composant.setAttribute(idf);
				Attribute type = new Attribute("type", composantCourant.getClass().getName());
				composant.setAttribute(type);

				// On parcourt les connexions
				for (int j = 0; j < composantCourant.getLengthSorties(); j++) {
					Element connexion = new Element("Connexion");
					composant.addContent(connexion);
					Attribute sortie;
					// Le try realise la gestion de l'exception soulevée en cas
					// d'indice trop élevé
					try {
						sortie = new Attribute("sortie",
								Integer.toString(composantCourant.getNiemePortSortie(j).getId_port()));
						connexion.setAttribute(sortie);
						// On récupère la liste des Destinatiosn de chaque
						// connexion
						for (int k = 0; k < composantCourant.getNiemePortSortie(j).getListePortEntreeConnectes()
								.size(); k++) {
							Element destination = new Element("Destination");
							connexion.addContent(destination);
							Attribute composantdest = new Attribute("composant",
									Integer.toString(composantCourant.getNiemePortSortie(j)
											.getListePortEntreeConnectes().get(k).getProprietairePort().getId()));
							destination.setAttribute(composantdest);
							Attribute entree = new Attribute("entree", Integer.toString(composantCourant
									.getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getId_port()));
							destination.setAttribute(entree);
						}
					} catch (PortInconnuException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		// On affiche le resultat en console
		affiche();
		// On crée le fichier output
		enregistre("output.xml");

	}

	/**
	 * Meme fonction que ci dessus, pour la récursion/A AMELIORER
	 */
	private void funComposite1(Circuit c)
	{
		Element composite = new Element("Composite");
		racine.addContent(composite);
		Attribute nomComposite = new Attribute("nom", ((Composite) c).getNom());
		composite.setAttribute(nomComposite);
		Attribute entreesComposite = new Attribute("entrees", Integer.toString(((Composite) c).getLengthEntrees()));
		composite.setAttribute(entreesComposite);
		Attribute sortiesComposite = new Attribute("sorties", Integer.toString(((Composite) c).getLengthSorties()));
		composite.setAttribute(sortiesComposite);

		for (int i = 1; i <= c.getComposants().size(); i++) {
			Composant composantCourant = c.getComposants().get(i);
			if (composantCourant instanceof Composite) {
				// On fait une récursion, t pour ça on se sert d'une autre
				// fonction similaire (à améliorer)
				funComposite2((Circuit) composantCourant);

			} else {

				// On parcourt les composants du composite
				Element composant = new Element("Composant");
				composite.addContent(composant);
				Attribute idf = new Attribute("idf", Integer.toString(composantCourant.getId()));
				composant.setAttribute(idf);
				Attribute type = new Attribute("type", composantCourant.getClass().getName());
				composant.setAttribute(type);

				for (int j = 0; j < composantCourant.getLengthSorties(); j++) {
					Element connexion = new Element("Connexion");
					composant.addContent(connexion);
					Attribute sortie;
					try {
						sortie = new Attribute("sortie",
								Integer.toString(composantCourant.getNiemePortSortie(j).getId_port()));
						connexion.setAttribute(sortie);
						for (int k = 0; k < composantCourant.getNiemePortSortie(j).getListePortEntreeConnectes()
								.size(); k++) {
							Element destination = new Element("Destination");
							connexion.addContent(destination);
							Attribute composantdest = new Attribute("composant",
									Integer.toString(composantCourant.getNiemePortSortie(j)
											.getListePortEntreeConnectes().get(k).getProprietairePort().getId()));
							destination.setAttribute(composantdest);
							Attribute entree = new Attribute("entree", Integer.toString(composantCourant
									.getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getId_port()));
							destination.setAttribute(entree);
						}
					} catch (PortInconnuException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
				}

				// interface attibut des composites
				Element interfaceES = new Element("Interface");
				composite.addContent(interfaceES);
				// Boucle parcourant les entrées/NON FINALISE
				for (int x = 0; x < composantCourant.getLengthEntrees(); x++) {
					Element entreesInterface = new Element("Entree");
					interfaceES.addContent(entreesInterface);
					Attribute portNum = new Attribute("port", Integer.toString(x + 1));
					entreesInterface.setAttribute(portNum);
				}
				// Parcourt la sortie/NON FINALISE
				Element sortieInterface = new Element("Sortie");
				interfaceES.addContent(sortieInterface);
				Attribute interfaceNb = new Attribute("Interface", Integer.toString(1));
				sortieInterface.setAttribute(interfaceNb);
				Attribute composantCo;
				try {
					composantCo = new Attribute("composante",
							Integer.toString(composantCourant.getNiemePortSortie(0).getProprietairePort().getId()));
					sortieInterface.setAttribute(composantCo);
					Attribute entreeCo = new Attribute("port",
							Integer.toString(composantCourant.getNiemePortSortie(0).getId_port()));
					sortieInterface.setAttribute(entreeCo);
				} catch (PortInconnuException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Meme fonction que ci dessus, pour la récursion/A AMELIORER
	 */
	private void funComposite2(Circuit c)
	{
		Element composite = new Element("Composite");
		racine.addContent(composite);
		Attribute nomComposite = new Attribute("nom", ((Composite) c).getNom());
		composite.setAttribute(nomComposite);
		Attribute entreesComposite = new Attribute("entrees", Integer.toString(((Composite) c).getLengthEntrees()));
		composite.setAttribute(entreesComposite);
		Attribute sortiesComposite = new Attribute("sorties", Integer.toString(((Composite) c).getLengthSorties()));
		composite.setAttribute(sortiesComposite);

		for (int i = 1; i < c.getComposants().size(); i++) {
			Composant composantCourant = c.getComposants().get(i);
			if (composantCourant instanceof Composite) {
				// Appel de la fonction ci-dessus pour la récursion
				funComposite1((Circuit) composantCourant);

			} else {

				Element composant = new Element("Composant");
				composite.addContent(composant);
				Attribute idf = new Attribute("idf", Integer.toString(composantCourant.getId()));
				composant.setAttribute(idf);
				Attribute type = new Attribute("type", composantCourant.getClass().getName());
				composant.setAttribute(type);

				for (int j = 0; j < composantCourant.getLengthSorties(); j++) {
					Element connexion = new Element("Connexion");
					composant.addContent(connexion);
					Attribute sortie;
					try {
						sortie = new Attribute("sortie",
								Integer.toString(composantCourant.getNiemePortSortie(j).getId_port()));
						connexion.setAttribute(sortie);
						for (int k = 0; k < composantCourant.getNiemePortSortie(j).getListePortEntreeConnectes()
								.size(); k++) {
							Element destination = new Element("Destination");
							connexion.addContent(destination);
							Attribute composantdest = new Attribute("composant",
									Integer.toString(composantCourant.getNiemePortSortie(j)
											.getListePortEntreeConnectes().get(k).getProprietairePort().getId()));
							destination.setAttribute(composantdest);
							Attribute entree = new Attribute("entree", Integer.toString(composantCourant
									.getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getId_port()));
							destination.setAttribute(entree);
						}
					} catch (PortInconnuException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Element interfaceES = new Element("Interface");
				composite.addContent(interfaceES);
				for (int x = 0; x < composantCourant.getLengthEntrees(); x++) {
					Element entreesInterface = new Element("Entree");
					interfaceES.addContent(entreesInterface);
					Attribute portNum = new Attribute("port", Integer.toString(x + 1));
					entreesInterface.setAttribute(portNum);
				}
				Element sortieInterface = new Element("Sortie");
				interfaceES.addContent(sortieInterface);
				Attribute interfaceNb = new Attribute("Interface", Integer.toString(1));
				sortieInterface.setAttribute(interfaceNb);
				Attribute composantCo;
				try {
					composantCo = new Attribute("composante",
							Integer.toString(composantCourant.getNiemePortSortie(0).getProprietairePort().getId()));
					sortieInterface.setAttribute(composantCo);
					Attribute entreeCo = new Attribute("port",
							Integer.toString(composantCourant.getNiemePortSortie(0).getId_port()));
					sortieInterface.setAttribute(entreeCo);
				} catch (PortInconnuException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Trouvé sur http://cynober.developpez.com/tutoriel/java/xml/jdom/, qui m'a
	 * aidé tout le long très explicatif!
	 */
	static void affiche()
	{
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, System.out);
		} catch (java.io.IOException e) {
		}
	}

	/**
	 * Meme source
	 */
	static void enregistre(String fichier)
	{
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream(fichier));
		} catch (java.io.IOException e) {
		}
	}
}