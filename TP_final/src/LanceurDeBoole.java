import projet.composant.*;
import projet.exception.ActionInterditeException;
import projet.exception.CircuitNonCompletException;
import projet.exception.ComposantInconnuException;
import projet.exception.PortInconnuException;


public class LanceurDeBoole {

	public static void main(String[] args) {
		
		
		
		
			
		/* Circuit 1
		 * 
		 * Vcc--------ET---LED
		 * 			|-
		 * Vcc--ET--|
		 * Gnd--
		 * 
		 */
		
		
		
		Circuit monCircuit = new Circuit("monCircuit");
		
		Itr A = new Itr(8);
		Itr B = new Itr(9);
		Itr Ce = new Itr(10);
		
		Led S = new Led(11);
		Led Cs = new Led(12);
		
		/* 
		 * Construction d'un Add1B en composite
		 * 
		 * Ports entrees 
		 * 
		 * 0 A
		 * 1 B
		 * 2 Ce
		 * 
		 * Ports sorties
		 * 
		 * 0 S
		 * 1 Cs
		 */
		Composite add1b = new Composite("Add1B", 0, 3, 2, 1);
		
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
			
			add1b.définirPortSortieComposant(2, 0, 0);
			add1b.définirPortSortieComposant(7, 0, 1);
			
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
		
		monCircuit.ajouterComposant(add1b);
		monCircuit.ajouterComposant(A);
		monCircuit.ajouterComposant(B);
		monCircuit.ajouterComposant(S);
		monCircuit.ajouterComposant(Ce);
		monCircuit.ajouterComposant(Cs);
			
		try {
			monCircuit.cabler(8, 0, 0, 0);
			monCircuit.cabler(9, 0, 0, 1);
			monCircuit.cabler(10, 0, 0, 2);
			
			monCircuit.cabler(0, 0, 11, 0);
			monCircuit.cabler(0, 1, 12, 0);
		} catch (ComposantInconnuException | PortInconnuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			monCircuit.changerItr(8);
			monCircuit.changerItr(9);
			monCircuit.changerItr(10);
			
			monCircuit.execute();
			System.out.println(monCircuit);
		} catch (CircuitNonCompletException | ComposantInconnuException | ActionInterditeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		
		
		
	}
		
		

}
