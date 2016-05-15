package projet.test;

import projet.composant.Circuit;
import projet.composant.Itr;
import projet.composant.Led;
import projet.composant.Oux;
import projet.exception.CircuitNonCompletException;
import projet.exception.ComposantInconnuException;
import projet.exception.PortInconnuException;

public class TestOux extends Circuit implements CircuitTesteur{

	public TestOux() {
		super("TestOux");
		ajouterComposant(new Oux(1));
		ajouterComposant(new Led(2));
		ajouterComposant(new Itr(3));
		ajouterComposant(new Itr(4));
		
		
		//Le cablage est sur, il n'y aura pas d'exception
		try {
			cabler(3, 0, 1, 0);
			cabler(4, 0, 1, 0);
			cabler(1, 0, 2, 0);
		} catch (ComposantInconnuException | PortInconnuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void tester() {
		//TODO A reimplement comme décrit dans l'interface
		
		System.out.println("************\nTest du oux :\n************\n\n");
		
		System.out.println(this);
		
		
		
		try {
			System.out.println("| Itr1 | Itr2 | Led |");
			execute();
			//TODO crée des accessuers pour les composants d'un circuit
			//Test 0-0 -> 0
			//Test 0-1 -> 0
			//Test 1-0 -> 0
			//Test 1-1 -> 0
			
			
			
		} catch (CircuitNonCompletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
		
		
	}

}
