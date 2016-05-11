
public class LanceurDeBoole {

	public static void main(String[] args) {
		
		Circuit monCircuit = new Circuit("monCircuit");
		
		
		Et et = new Et(1);
		Vcc vcc= new Vcc(2);
		Led led = new Led(3);
				
		monCircuit.ajouterComposant(et);
		monCircuit.ajouterComposant(vcc);
		monCircuit.ajouterComposant(led);
		
		monCircuit.cabler(2,0,1,0);
		monCircuit.cabler(2,0,1,1);
		monCircuit.cabler(1,0,3,0);		
		
		monCircuit.execute();
		
		System.out.println(monCircuit.toString());
		
		
	}

}
