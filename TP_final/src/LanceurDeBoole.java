public class LanceurDeBoole {

	public static void main(String[] args) {
		
		Circuit monCircuit = new Circuit("monCircuit");
		
		Et et = new Et(1);
		Vcc vcc= new Vcc(2);
		Led led = new Led(3);
				
		monCircuit.ajouterComposant(et);
		monCircuit.ajouterComposant(vcc);
		monCircuit.ajouterComposant(led);
		
		//On cable le port de sortie 0 du composant 2 au port d'entree 0 du composant 1
		monCircuit.cabler(2,0,1,0);
		monCircuit.cabler(2,0,1,1);
		monCircuit.cabler(1,0,3,0);		
		
		//On execute le circuit
		monCircuit.execute();
		
		System.out.println(monCircuit.toString());
		
		
	}

}
