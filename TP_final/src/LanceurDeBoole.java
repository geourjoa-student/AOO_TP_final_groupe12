import parser.Jdom;
import projet.composant.*;
import projet.exception.ActionInterditeException;
import projet.exception.CircuitNonCompletException;
import projet.exception.ComposantInconnuException;
import projet.exception.PortInconnuException;
import projet.test.CircuitTesteur;


public class LanceurDeBoole {

	public static void main(String[] args) {
		
		
		//CircuitTesteur monCircuit = new CircuitTesteur();
		
		Circuit monCircuit = new Circuit("monCircuit");
		
		Composite nonComposite = new Composite("nomCompite", 2, 1, 1, 1);
		nonComposite.ajouterComposant(new Non(1));
		try {
			nonComposite.connecterPortEntreeComposant(1, 0, 0);
			nonComposite.definirPortSortieComposant(1, 0, 0);
		} catch (PortInconnuException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		monCircuit.ajouterComposant(new Itr(1));
		monCircuit.ajouterComposant(nonComposite);
		monCircuit.ajouterComposant(new Led(3));
		
		try {
			monCircuit.cabler(1, 0, 2, 0);
			monCircuit.cabler(2, 0, 3, 0);
		} catch (ComposantInconnuException | PortInconnuException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		//monCircuit.tester();
		
		System.out.println(monCircuit);
		
		Jdom monjj = new Jdom();
		
		monjj.createDoc(monCircuit);
		
			
		
		
		
		
	
		
		
		
	}
		
		

}
