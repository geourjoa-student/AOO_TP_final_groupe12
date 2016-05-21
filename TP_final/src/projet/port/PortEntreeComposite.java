package projet.port;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import projet.composant.Composant;

public class PortEntreeComposite extends PortEntree{
	
	private List<PortEntree> portsEntreeComposantsInternesConnectes;

	public PortEntreeComposite(Composant proprietaire, int id) {
		super(proprietaire, id);
		
		portsEntreeComposantsInternesConnectes = new ArrayList<PortEntree>();
	}
	
	public void ajouterPortEntreeComposantInterne (PortEntree pe){
		portsEntreeComposantsInternesConnectes.add(pe);
	}
	
	public void setValeur(boolean valeur) {
		this.valeur = valeur;
		
		for (Iterator<PortEntree> iterator = portsEntreeComposantsInternesConnectes.iterator(); iterator.hasNext();) {
			PortEntree pe = (PortEntree) iterator.next();
			
			pe.setValeur(valeur);
		}
	}

	public List<PortEntree> getPortsEntreeComposantsInternesConnectes() {
		return portsEntreeComposantsInternesConnectes;
	}
	
	

}
