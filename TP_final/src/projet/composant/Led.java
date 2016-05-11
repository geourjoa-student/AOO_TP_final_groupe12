package projet.composant;
import projet.port.PortEntree;
import projet.port.PortSortie;

public class Led extends Recepteur {
	
	public Boolean allume;

	public Boolean estAllume() {
		return allume;
	}

	@Override
	public void calculerSorties() {
		allume = this.portsEntrees[0].isValeur();
		this.portsSorties[0].setValeur(this.portsEntrees[0].isValeur());
	}

	public Led(int id) {
		portsEntrees = new PortEntree[1];
		portsSorties = new PortSortie[1];
		
		portsEntrees[0] = new PortEntree(this,0);	
		portsSorties[0] = new PortSortie(this,0);
		
		this.id = id;
		
		this.allume=true;
	}
	
	

	@Override
	public String toString() {
	
		String s = "<" + id + "| Led (" + portsEntrees.length + "," + portsSorties.length + "){"
				+ ((allume) ? "allume" : "eteint") + "} -> ";

		for (int i = 0; i < portsEntrees.length; i++) {
			s += "#" + portsSorties[i].getId_port() + "(";
			for (int j = 0; j < portsEntrees.length; j++) {
				s += portsEntrees[i].getProprietairePort().getId() + "#" + portsEntrees[i].getId_port() + ",";
			}
			s+=")";
		}

		s += ">";

		return s;
	}

	
}