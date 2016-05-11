import projet.composant.*;

public class LanceurDeBoole {

	public static void main(String[] args) {
		
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
		
		//On execute le circuit
		monCircuit.execute();
		
		System.out.println(monCircuit.toString());
		
		
	}

}
