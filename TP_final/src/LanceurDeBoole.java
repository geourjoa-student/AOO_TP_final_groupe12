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
		
		/*
		 
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
		
		*/
		
		Circuit monCircuit3 = new Circuit("Test Oux Composite");
		
		
		Itr it1 = new Itr(12);
		Et et4 = new Et(13);
		Et et5 = new Et(14);
		Non non1 = new Non(15);
		Non non2 = new Non(16);
		Ou Ou1 = new Ou(17);
		Repeteur rep1 = new Repeteur(18);
		Repeteur rep2 = new Repeteur(19);
		
		Composite oux = new Composite("Oux", 20, 2, 1,1);
		
		Led led3 = new Led(21);
		
		monCircuit3.ajouterComposant(it1);
		monCircuit3.ajouterComposant(led3);
		
		oux.ajouterComposant(et4);
		oux.ajouterComposant(et5);
		oux.ajouterComposant(non1);
		oux.ajouterComposant(non2);
		oux.ajouterComposant(Ou1);
		oux.ajouterComposant(rep1);
		oux.ajouterComposant(rep2);
		
		oux.cabler(18, 0, 13, 0);
		oux.cabler(18, 0, 16, 0);
		
		oux.cabler(19, 0, 14, 0);
		oux.cabler(19, 0, 15, 0);
		
		oux.cabler(13, 0, 17, 0);
		oux.cabler(14, 0, 17, 1);
		
		oux.cabler(15, 0, 13, 1);
		oux.cabler(16, 0, 14, 1);
		
		oux.definirPortEntreeComposant(18, 0, 0);
		oux.definirPortEntreeComposant(19, 0, 1);
		oux.definirPortSortieComposant(17, 0, 0);
		
		monCircuit3.ajouterComposant(oux);
		
		monCircuit3.cabler(12, 0, 20, 0);
		monCircuit3.cabler(12, 0, 20, 1);
		monCircuit3.cabler(20, 0, 21, 0);
		
		try {
			monCircuit3.execute();
		} catch (Exception e) {
			
			System.out.println("Le circuit n'est pas complet");
		}
		
		System.out.println(monCircuit3);
		
	}

}
