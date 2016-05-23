package projet.test;

import projet.composant.Circuit;
import projet.composant.Itr;
import projet.composant.Led;
import projet.composant.Oux;
import projet.exception.ActionInterditeException;
import projet.exception.CircuitNonCompletException;
import projet.exception.ComposantInconnuException;
import projet.exception.PortInconnuException;

/**
 * @author anthony Circuit un peu spécial permettant de tester le composant oux.
 *         En réalité, il s'agit d'un circuit classique, précablé et
 *         implémentant Testeur
 */
public class TestOux extends Circuit implements Testeur {

	public TestOux() {
		super("TestOux");
		ajouterComposant(new Oux(1));
		ajouterComposant(new Led(2));
		ajouterComposant(new Itr(3));
		ajouterComposant(new Itr(4));

		// Le cablage est sur, il n'y aura pas d'exception.
		try {
			cabler(3, 0, 1, 0);
			cabler(4, 0, 1, 1);
			cabler(1, 0, 2, 0);
		} catch (ComposantInconnuException | PortInconnuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Test selon les 4 combinaisons possibles, le test n'est pas généralisable
	 * en l'état
	 * 
	 * @see projet.test.Testeur#tester()
	 */
	public void tester() {

		System.out.println("************\nTest du oux :\n************\n\n");

		System.out.println(this);

		try {

			// Test 0-0 -> 0

			changerItr(3);
			changerItr(4);
			execute();
			System.out.println(observerItr(3) + " (+) " + observerItr(4) + " = " + observerLed(2));

			// Test 0-1 -> 0
			changerItr(4);
			execute();
			System.out.println(observerItr(3) + " (+) " + observerItr(4) + " = " + observerLed(2));

			// Test 1-0 -> 0

			changerItr(3);
			changerItr(4);
			execute();
			System.out.println(observerItr(3) + " (+) " + observerItr(4) + " = " + observerLed(2));

			// Test 1-1 -> 0
			changerItr(4);
			execute();
			System.out.println(observerItr(3) + " (+) " + observerItr(4) + " = " + observerLed(2));

		} catch (CircuitNonCompletException | ComposantInconnuException | ActionInterditeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();

	}

}
