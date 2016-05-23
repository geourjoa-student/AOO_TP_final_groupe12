import parser.Jdom;
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
		
		monCircuit.ajouterComposant(A);
		monCircuit.ajouterComposant(B);
		monCircuit.ajouterComposant(new Aff4bc2(3));
		monCircuit.ajouterComposant(new Led(4));
		monCircuit.ajouterComposant(new Gnd(5));
		
		monCircuit.ajouterComposant(add1b0);
		monCircuit.ajouterComposant(add1b1);
		monCircuit.ajouterComposant(add1b2);
		monCircuit.ajouterComposant(add1b3);
	
		
		try {
			//Cablage du A
			monCircuit.cabler(1, 0, 6, 0);
			monCircuit.cabler(1, 1, 7, 0);
			monCircuit.cabler(1, 2, 8, 0);
			monCircuit.cabler(1, 3, 9, 0);
			
			//Cablage du B
			monCircuit.cabler(2, 0, 6, 1);
			monCircuit.cabler(2, 1, 7, 1);
			monCircuit.cabler(2, 2, 8, 1);
			monCircuit.cabler(2, 3, 9, 1);
			
			//Retenue entrante de 0
			monCircuit.cabler(5, 0, 6, 2);
			
			//retenues propagées
			monCircuit.cabler(6, 1, 7, 2);
			monCircuit.cabler(7, 1, 8, 2);
			monCircuit.cabler(8, 1, 9, 2);
			monCircuit.cabler(9, 1, 4, 0);
			
			//resultat
			monCircuit.cabler(6, 0, 3, 0);
			monCircuit.cabler(7, 0, 3, 1);
			monCircuit.cabler(8, 0, 3, 2);
			monCircuit.cabler(9, 0, 3, 3);
		} catch (ComposantInconnuException | PortInconnuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			monCircuit.execute();
		} catch (CircuitNonCompletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(monCircuit);
		
		Jdom monjj = new Jdom();
		
		monjj.createDoc(monCircuit);
		
			
		
		
		
		
	
		
		
		
	}
		
		

}
