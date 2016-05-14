import projet.composant.*;

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
		
		/*
		
		Circuit monCircuit = new Circuit("monCircuit");
		
		Et et1 = new Et(1);
		Vcc vcc= new Vcc(2);
		Led led = new Led(3);
		Et et2 = new Et(4);
		Gnd gnd = new Gnd(5);
				
		monCircuit.ajouterComposant(et1);
		monCircuit.ajouterComposant(vcc);
		monCircuit.ajouterComposant(led);
		monCircuit.ajouterComposant(et2);
		monCircuit.ajouterComposant(gnd);
		
		//On cable le port de sortie 0 du composant 2 au port d'entree 0 du composant 1
		monCircuit.cabler(2,0,1,0);
		monCircuit.cabler(2,0,4,0);
		
		monCircuit.cabler(5,0,4,1);
		monCircuit.cabler(4,0,1,1);
		monCircuit.cabler(1,0,3,0);		
		
		try {
			monCircuit.execute();
		} catch (Exception e) {
			
			System.out.println("Le circuit n'est pas complet");
		}
		
		System.out.println(monCircuit.toString());
		
		*/
		
		Circuit monCircuit2 = new Circuit("monCircuit2");
		
		Vcc vcc2= new Vcc(6);
		Led led2 = new Led(7);
		Et et3 = new Et(8);
		Non non = new Non(9);
		Composite nand = new Composite("Nand", 10, 2, 1);
		
		Gnd gnd2 = new Gnd(11);
		
		nand.ajouterComposant(et3);
		nand.ajouterComposant(non);
		
		nand.cabler(8, 0, 9, 0);
		nand.definirPortEntreeComposant(8, 0, 0);
		nand.definirPortEntreeComposant(8, 1, 1);
		nand.definirPortSortieComposant(9, 0, 0);
		
		monCircuit2.ajouterComposant(nand);
		monCircuit2.ajouterComposant(vcc2);
		monCircuit2.ajouterComposant(led2);
		monCircuit2.ajouterComposant(gnd2);
		
		monCircuit2.cabler(6, 0, 10, 0);
		monCircuit2.cabler(11, 0, 10, 1);
		monCircuit2.cabler(10, 0, 7, 0);
		
		try {
			monCircuit2.execute();
		} catch (Exception e) {
			
			System.out.println("Le circuit n'est pas complet");
		}
		
		System.out.println(monCircuit2);
		
		
	}

}
