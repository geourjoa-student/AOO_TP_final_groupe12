import projet.composant.*;
import projet.exception.CircuitNonCompletException;
import projet.exception.ComposantInconnuException;
import projet.exception.PortInconnuException;
import projet.test.TestOux;

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
		
		Composite oux = new Composite("Oux", 0, 2, 1, 1);
		
		
		
		Et et1 = new Et(1);
		Et et2 = new Et(2);
		
		Ou ou1 = new Ou(3);
		
		Non non1 = new Non(4);
		Non non2 = new Non(5);
			
		Vcc vcc= new Vcc(6);
		Gnd gnd = new Gnd(7);
		
		Led led = new Led(8);
				
		oux.ajouterComposant(et1);
		oux.ajouterComposant(et2);
		oux.ajouterComposant(ou1);
		oux.ajouterComposant(non1);
		oux.ajouterComposant(non2);
		
		try {
			oux.cabler(1, 0, 3, 0);
			oux.cabler(2, 0, 3, 1);
			oux.cabler(4, 0, 1, 1);
			oux.cabler(5, 0, 2, 0);
			
			oux.définirPortSortieComposant(3, 0, 0);
			
			oux.connecterPortEntreeComposant(1, 0, 0);
			oux.connecterPortEntreeComposant(2, 1, 1);
			oux.connecterPortEntreeComposant(4, 0, 1);
			oux.connecterPortEntreeComposant(5, 0, 0);
		} catch (ComposantInconnuException | PortInconnuException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		monCircuit.ajouterComposant(led);
		
		monCircuit.ajouterComposant(vcc);
		monCircuit.ajouterComposant(gnd);
		
		monCircuit.ajouterComposant(oux);
		
		
		try {
			monCircuit.cabler(6,0,0,0);
			monCircuit.cabler(7,0,0,1);
			
			monCircuit.cabler(0,0,8,0);
		} catch (ComposantInconnuException | PortInconnuException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		try {
			monCircuit.execute();
		} catch (Exception e) {
			
			System.out.println("Le circuit n'est pas complet");
		}
		
		System.out.println(monCircuit.toString());
		
		
		
	}
		
		

}
