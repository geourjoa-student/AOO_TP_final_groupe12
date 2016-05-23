package projet.composant;
import java.util.Iterator;

import projet.port.PortEntree;
import projet.port.PortSortie;

public class Itr extends Generateur {
	
	static final boolean HAUT = true;
	
	static final boolean FALSE = false;

	private Boolean etat;

	public Boolean getEtat()
	{
		return etat;
	}

	public void changerEtat()
	{
		etat = !etat;
	}
	
	public void setEtat(boolean nouvelEtat)
	{
		etat = nouvelEtat;
	}

	@Override
	public void calculerSorties()
	{
		this.portsSorties[0].setValeur(etat);
		portsSorties[0].propagerValeur();
	}

	public Itr(int id){
		
		nbPortsEntree=0;
		nbPortsSortie=1;

		portsSorties = new PortSortie[nbPortsSortie];
			
		portsSorties[0] = new PortSortie(this,0);
		etat = HAUT;
		this.id = id;
	}

	@Override
	public String toString()
	{

		String s = "<" + id + "| Itr (" + 0 + "," + portsSorties.length + "){" + ((etat)?"haut":"bas") + "}->";

		for (int i = 0; i < portsSorties.length; i++) 
		{
			s += "#" + portsSorties[i].getId_port() +"(";
					
			for (Iterator<PortEntree> it = portsSorties[i].getListePortEntreeConnectes().iterator(); it.hasNext();) {
				PortEntree pe = it.next();
				s+=  pe.getProprietairePort().getId() + "#" + pe.getId_port(); 
				
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