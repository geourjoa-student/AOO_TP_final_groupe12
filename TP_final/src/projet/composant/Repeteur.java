package projet.composant;

import java.util.Iterator;

import projet.port.PortEntree;
import projet.port.PortSortie;


/* Ce composant a pour but de résoudre le problème d'un composite qui 
 * repete une valeur d'un de ses ports d'entrees. Par exemple un oux réutilise 
 * deux fois ses valeurs d'entrees.
 * On cable donc le port d'entree du composite sur le port d'entrée du repeteur et on
 *  connecte les ports d'entrées des composants voulant utiliser la valeur sur le port
 *  de sortie du repeteur.
 */
public class Repeteur extends Transformateur {

	public Repeteur (int id){
		
		nbPortsEntree=1;
		nbPortsSortie=1;
		portsEntrees = new PortEntree[nbPortsEntree];
		portsSorties = new PortSortie[nbPortsSortie];
		
		portsEntrees[0] = new PortEntree(this, 0);
		portsSorties[0] = new PortSortie(this, 0);
		
		this.id = id;
	}
	
	
	@Override
	public void calculerSorties() {
		this.portsSorties[0].setValeur(this.portsEntrees[0].isValeur());
		portsSorties[0].propagerValeur();	
	}
	
	@Override
	public String toString()
	{
	
		String s = "<" + id + "| Repeteur (" +  1 + "," + 1 + ") -> ";

		for (int i = 0; i < portsSorties.length; i++) 
		{
			s += "#" + portsSorties[i].getId_port() +"(";
					
			for (Iterator<PortEntree> it = portsSorties[i].getListePortEntreeConnectes().iterator(); it.hasNext();) {
				PortEntree pe = it.next();
				s+=  pe.getProprietairePort().getId() + "#" + pe.getId_port() ;
				
				if(it.hasNext()){
					s+= ",";
				}
			}		
			s+=")";	
		}

		s += ">";

		return s;
	}

}
