package projet.composant;
import projet.port.PortEntree;

public class Led extends Recepteur {
	
	private Boolean allume;

	public Boolean estAllume() {
		return allume;
	}

	@Override
	public void calculerSorties() {
		allume = this.portsEntrees[0].isValeur();
	}

	public Led(int id) {
		
		nbPortsEntree=1;
		nbPortsSortie=0;
		portsEntrees = new PortEntree[nbPortsEntree];
		
		portsEntrees[0] = new PortEntree(this,0);	
		
		this.id = id;
		
		this.allume=true;
	}
	
	

	@Override
	public String toString() {
	
		String s = "<" + id + "| Led (" + portsEntrees.length + "," + 0 + "){"
				+ ((allume) ? "allume" : "eteint") + "} > ";

		return s;
	}

	
}