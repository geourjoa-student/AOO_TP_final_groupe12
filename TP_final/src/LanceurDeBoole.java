import java.rmi.dgc.Lease;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

import parser.Jdom;
import projet.composant.*;
import projet.exception.ActionInterditeException;
import projet.exception.CircuitNonCompletException;
import projet.exception.ComposantInconnuException;
import projet.exception.PortInconnuException;
import projet.test.CircuitTesteur;
import projet.test.TestOux;

public class LanceurDeBoole {

	public static void main(String[] args) {

		System.out.println(
				"Nous n'avons pu développer un programme permettant à un utilisateur d'interargir avec notre moteur.");
		System.out.println(
				"Ce programme est donc uniquement une démonstration des possibilités offertes par notre noyau boole et présentera différents scénarios.\n");

		int choix = 1;

		while (choix != 0) {

			System.out.println("Choississez le numéro de la démonstration souhaitée :");
			System.out.println("1 - Affichage d'un composite : l'additionneur 1 bit");
			System.out.println(
					"2 - Mise en oeuvre de l'additionneur 1 bit dans un circuit avec une led, 2 Vcc et un Gnd");
			System.out.println("3 - Mise en oeuvre d'un additionneur 4 bits dans un circuit");
			System.out.println("4 - Mise en oeuvre du test de la classe testOux");
			System.out.println("5 - Mise en oeuvre du test de la classe CircuitTesteur avec un oux");
			System.out.println("6 - Exportation d'un circuit simple en XML");
			System.out.println("0 - Quitter");

			System.out.println("\n");
			
			Scanner sc = new Scanner(System.in);
			choix = sc.nextInt();

			/* Varaible pour les démos */

			Composite add1b = new Composite("Add1B", 3, 3, 2, 0);

			Oux oux1 = new Oux(1);
			Oux oux2 = new Oux(2);

			Et et1 = new Et(3);
			Et et2 = new Et(4);
			Et et3 = new Et(5);

			Ou ou1 = new Ou(6);
			Ou ou2 = new Ou(7);

			add1b.ajouterComposant(oux1);
			add1b.ajouterComposant(oux2);
			add1b.ajouterComposant(ou1);
			add1b.ajouterComposant(ou2);
			add1b.ajouterComposant(et1);
			add1b.ajouterComposant(et2);
			add1b.ajouterComposant(et3);

			try {
				add1b.cabler(1, 0, 2, 0);
				add1b.cabler(6, 0, 7, 0);
				add1b.cabler(3, 0, 6, 0);
				add1b.cabler(4, 0, 6, 1);
				add1b.cabler(5, 0, 7, 1);

				add1b.definirPortSortieComposant(2, 0, 0);
				add1b.definirPortSortieComposant(7, 0, 1);

				add1b.connecterPortEntreeComposant(1, 0, 0);
				add1b.connecterPortEntreeComposant(3, 0, 0);
				add1b.connecterPortEntreeComposant(4, 0, 0);

				add1b.connecterPortEntreeComposant(1, 1, 1);
				add1b.connecterPortEntreeComposant(3, 1, 1);
				add1b.connecterPortEntreeComposant(5, 0, 1);

				add1b.connecterPortEntreeComposant(2, 1, 2);
				add1b.connecterPortEntreeComposant(4, 1, 2);
				add1b.connecterPortEntreeComposant(5, 1, 2);
			} catch (ComposantInconnuException | PortInconnuException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Circuit monCircuit = new Circuit("monCircuit");
			monCircuit.ajouterComposant(new Vcc(1));
			monCircuit.ajouterComposant(new Gnd(2));
			monCircuit.ajouterComposant(add1b);
			monCircuit.ajouterComposant(new Led(4));
			monCircuit.ajouterComposant(new Led(5));

			try {
				monCircuit.cabler(1, 0, 3, 0);
				monCircuit.cabler(1, 0, 3, 1);
				monCircuit.cabler(2, 0, 3, 2);
				monCircuit.cabler(3, 0, 4, 0);
				monCircuit.cabler(3, 1, 5, 0);
			} catch (ComposantInconnuException | PortInconnuException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (choix) {
			case 1:

				System.out.println("1 - Affichage d'un composite : l'additionneur 1 bit : \n");

				System.out.println(add1b);

				break;

			case 2:

				System.out.println(
						"2 - Mise en oeuvre de l'additionneur 1 bit dans un circuit avec une led, 2 Vcc et un Gnd\n");

				System.out.println(
						"Le circuit produit bien les résulats attendus (led 4 résultat, led 5 retenue sortante)");

				try {
					monCircuit.execute();
				} catch (CircuitNonCompletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(monCircuit);

				break;

			case 3:

				System.out.println("3 - Mise en oeuvre d'un additionneur 4 bits dans un circuit\n\n");

				Circuit monCircuit2 = new Circuit("monCircuit");

				Composite add1b0 = new Composite("Add1B0", 6, 3, 2, 1);

				add1b0.ajouterComposant(new Oux(1));
				add1b0.ajouterComposant(new Oux(2));
				add1b0.ajouterComposant(new Et(3));
				add1b0.ajouterComposant(new Et(4));
				add1b0.ajouterComposant(new Et(5));
				add1b0.ajouterComposant(new Ou(6));
				add1b0.ajouterComposant(new Ou(7));

				try {
					add1b0.cabler(1, 0, 2, 0);
					add1b0.cabler(6, 0, 7, 0);
					add1b0.cabler(3, 0, 6, 0);
					add1b0.cabler(4, 0, 6, 1);
					add1b0.cabler(5, 0, 7, 1);

					add1b0.definirPortSortieComposant(2, 0, 0);
					add1b0.definirPortSortieComposant(7, 0, 1);

					add1b0.connecterPortEntreeComposant(1, 0, 0);
					add1b0.connecterPortEntreeComposant(3, 0, 0);
					add1b0.connecterPortEntreeComposant(4, 0, 0);

					add1b0.connecterPortEntreeComposant(1, 1, 1);
					add1b0.connecterPortEntreeComposant(3, 1, 1);
					add1b0.connecterPortEntreeComposant(5, 0, 1);

					add1b0.connecterPortEntreeComposant(2, 1, 2);
					add1b0.connecterPortEntreeComposant(4, 1, 2);
					add1b0.connecterPortEntreeComposant(5, 1, 2);
				} catch (ComposantInconnuException | PortInconnuException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Composite add1b1 = new Composite("Add1B1", 7, 3, 2, 1);

				add1b1.ajouterComposant(new Oux(1));
				add1b1.ajouterComposant(new Oux(2));
				add1b1.ajouterComposant(new Et(3));
				add1b1.ajouterComposant(new Et(4));
				add1b1.ajouterComposant(new Et(5));
				add1b1.ajouterComposant(new Ou(6));
				add1b1.ajouterComposant(new Ou(7));

				try {
					add1b1.cabler(1, 0, 2, 0);
					add1b1.cabler(6, 0, 7, 0);
					add1b1.cabler(3, 0, 6, 0);
					add1b1.cabler(4, 0, 6, 1);
					add1b1.cabler(5, 0, 7, 1);

					add1b1.definirPortSortieComposant(2, 0, 0);
					add1b1.definirPortSortieComposant(7, 0, 1);

					add1b1.connecterPortEntreeComposant(1, 0, 0);
					add1b1.connecterPortEntreeComposant(3, 0, 0);
					add1b1.connecterPortEntreeComposant(4, 0, 0);

					add1b1.connecterPortEntreeComposant(1, 1, 1);
					add1b1.connecterPortEntreeComposant(3, 1, 1);
					add1b1.connecterPortEntreeComposant(5, 0, 1);

					add1b1.connecterPortEntreeComposant(2, 1, 2);
					add1b1.connecterPortEntreeComposant(4, 1, 2);
					add1b1.connecterPortEntreeComposant(5, 1, 2);
				} catch (ComposantInconnuException | PortInconnuException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Composite add1b2 = new Composite("Add1B2", 8, 3, 2, 1);

				add1b2.ajouterComposant(new Oux(1));
				add1b2.ajouterComposant(new Oux(2));
				add1b2.ajouterComposant(new Et(3));
				add1b2.ajouterComposant(new Et(4));
				add1b2.ajouterComposant(new Et(5));
				add1b2.ajouterComposant(new Ou(6));
				add1b2.ajouterComposant(new Ou(7));

				try {
					add1b2.cabler(1, 0, 2, 0);
					add1b2.cabler(6, 0, 7, 0);
					add1b2.cabler(3, 0, 6, 0);
					add1b2.cabler(4, 0, 6, 1);
					add1b2.cabler(5, 0, 7, 1);

					add1b2.definirPortSortieComposant(2, 0, 0);
					add1b2.definirPortSortieComposant(7, 0, 1);

					add1b2.connecterPortEntreeComposant(1, 0, 0);
					add1b2.connecterPortEntreeComposant(3, 0, 0);
					add1b2.connecterPortEntreeComposant(4, 0, 0);

					add1b2.connecterPortEntreeComposant(1, 1, 1);
					add1b2.connecterPortEntreeComposant(3, 1, 1);
					add1b2.connecterPortEntreeComposant(5, 0, 1);

					add1b2.connecterPortEntreeComposant(2, 1, 2);
					add1b2.connecterPortEntreeComposant(4, 1, 2);
					add1b2.connecterPortEntreeComposant(5, 1, 2);
				} catch (ComposantInconnuException | PortInconnuException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Composite add1b3 = new Composite("Add1B3", 9, 3, 2, 1);

				add1b3.ajouterComposant(new Oux(1));
				add1b3.ajouterComposant(new Oux(2));
				add1b3.ajouterComposant(new Et(3));
				add1b3.ajouterComposant(new Et(4));
				add1b3.ajouterComposant(new Et(5));
				add1b3.ajouterComposant(new Ou(6));
				add1b3.ajouterComposant(new Ou(7));

				try {
					add1b3.cabler(1, 0, 2, 0);
					add1b3.cabler(6, 0, 7, 0);
					add1b3.cabler(3, 0, 6, 0);
					add1b3.cabler(4, 0, 6, 1);
					add1b3.cabler(5, 0, 7, 1);

					add1b3.definirPortSortieComposant(2, 0, 0);
					add1b3.definirPortSortieComposant(7, 0, 1);

					add1b3.connecterPortEntreeComposant(1, 0, 0);
					add1b3.connecterPortEntreeComposant(3, 0, 0);
					add1b3.connecterPortEntreeComposant(4, 0, 0);

					add1b3.connecterPortEntreeComposant(1, 1, 1);
					add1b3.connecterPortEntreeComposant(3, 1, 1);
					add1b3.connecterPortEntreeComposant(5, 0, 1);

					add1b3.connecterPortEntreeComposant(2, 1, 2);
					add1b3.connecterPortEntreeComposant(4, 1, 2);
					add1b3.connecterPortEntreeComposant(5, 1, 2);
				} catch (ComposantInconnuException | PortInconnuException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Gen4bc2 A = new Gen4bc2(1);
				A.setValeur(-2);
				Gen4bc2 B = new Gen4bc2(2);
				B.setValeur(3);

				monCircuit2.ajouterComposant(A);
				monCircuit2.ajouterComposant(B);
				monCircuit2.ajouterComposant(new Aff4bc2(3));
				monCircuit2.ajouterComposant(new Led(4));
				monCircuit2.ajouterComposant(new Gnd(5));

				monCircuit2.ajouterComposant(add1b0);
				monCircuit2.ajouterComposant(add1b1);
				monCircuit2.ajouterComposant(add1b2);
				monCircuit2.ajouterComposant(add1b3);

				try {
					// Cablage du A
					monCircuit2.cabler(1, 0, 6, 0);
					monCircuit2.cabler(1, 1, 7, 0);
					monCircuit2.cabler(1, 2, 8, 0);
					monCircuit2.cabler(1, 3, 9, 0);

					// Cablage du B
					monCircuit2.cabler(2, 0, 6, 1);
					monCircuit2.cabler(2, 1, 7, 1);
					monCircuit2.cabler(2, 2, 8, 1);
					monCircuit2.cabler(2, 3, 9, 1);

					// Retenue entrante de 0
					monCircuit2.cabler(5, 0, 6, 2);

					// retenues propagées
					monCircuit2.cabler(6, 1, 7, 2);
					monCircuit2.cabler(7, 1, 8, 2);
					monCircuit2.cabler(8, 1, 9, 2);
					monCircuit2.cabler(9, 1, 4, 0);

					// resultat
					monCircuit2.cabler(6, 0, 3, 0);
					monCircuit2.cabler(7, 0, 3, 1);
					monCircuit2.cabler(8, 0, 3, 2);
					monCircuit2.cabler(9, 0, 3, 3);
				} catch (ComposantInconnuException | PortInconnuException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					monCircuit2.execute();
				} catch (CircuitNonCompletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(monCircuit2);

				break;
				
			case 4 :
				
				System.out.println("4 - Mise en oeuvre du test de la classe testOux\n\n");
				
				TestOux test = new TestOux();
				
				test.tester();
				
				break;
				
			case 5 : 
				
				CircuitTesteur testeur = new CircuitTesteur();
				
				testeur.ajouterComposant(new Oux(1));
				testeur.ajouterComposant(new Itr(2));
				testeur.ajouterComposant(new Led(3));
				testeur.ajouterComposant(new Itr(4));
				
				try {
					testeur.cabler(2, 0, 1, 0);
					testeur.cabler(4, 0, 1, 1);
					testeur.cabler(1, 0, 3, 0);
				} catch (ComposantInconnuException | PortInconnuException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(testeur);
				
				testeur.tester();
				
				System.out.println("\n\nOn remarque que les résulats sont cohérents.\n\n");
				
				break;

			case 6:

				System.out.println("6 - Exportation d'un circuit simple en XML\n\n");

				Jdom monJDom = new Jdom();
				monJDom.createDoc(monCircuit);

				break;
				
			case 0 :
				break;

			default:
				System.out.println("Choix incorrect");
				break;
			}

		}
		// CircuitTesteur monCircuit = new CircuitTesteur();

		/*
		 * Circuit monCircuit = new Circuit("monCircuit");
		 * 
		 * Composite nonComposite = new Composite("nomCompite", 2, 1, 1, 1);
		 * nonComposite.ajouterComposant(new Non(1)); try {
		 * nonComposite.connecterPortEntreeComposant(1, 0, 0);
		 * nonComposite.definirPortSortieComposant(1, 0, 0); } catch
		 * (PortInconnuException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 * 
		 * monCircuit.ajouterComposant(new Itr(1));
		 * monCircuit.ajouterComposant(nonComposite);
		 * monCircuit.ajouterComposant(new Led(3));
		 * 
		 * try { monCircuit.cabler(1, 0, 2, 0); monCircuit.cabler(2, 0, 3, 0); }
		 * catch (ComposantInconnuException | PortInconnuException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 * 
		 * // monCircuit.tester();
		 * 
		 * System.out.println(monCircuit);
		 * 
		 * Jdom monjj = new Jdom();
		 * 
		 * monjj.createDoc(monCircuit);
		 */

	}

}
