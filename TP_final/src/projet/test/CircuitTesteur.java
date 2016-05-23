package projet.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import projet.composant.Circuit;
import projet.composant.Composant;
import projet.composant.Itr;
import projet.composant.Led;
import projet.exception.CircuitNonCompletException;

public class CircuitTesteur extends Circuit{

	public CircuitTesteur() {
		super("Circuit testeur");
	}
	
	private List<Itr> getListeItr() {
		
		List<Itr> listeItr = new ArrayList<Itr>();
		
		for (Composant c : composants.values()) {
			if (c instanceof Itr) {
				listeItr.add((Itr) c);
			}
		}
		
		return listeItr;
		
	}
	
	private List<Led> getListeLed() {
		
		List<Led> listeLed = new ArrayList<Led>();
		
		for (Composant c : composants.values()) {
			if (c instanceof Led) {
				listeLed.add((Led) c);
			}
		}
		
		return listeLed;
		
	}
		
	
	public void tester () {
		
		List<Led> listeLed = getListeLed();
		List<Itr> listeItr = getListeItr();
		
		afficherEnTete(listeItr, listeLed);
		
		for(int i=0; i<Math.pow(2, listeItr.size()); i++){
			
			try {
				modifierItr(listeItr,i);
				execute();
				afficherResultat(listeItr,listeLed);
			} catch (CircuitNonCompletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Afficher
			
		}
		
	}

	private void afficherEnTete(List<Itr> listeItr, List<Led> listeLed) {
		String s ="|";
		
		for (Iterator<Itr> iterator = listeItr.iterator(); iterator.hasNext();) {
			
			s+=  " " + iterator.next().getId() + " |";
			
		}
		
		s+="| ";
		
		for (Iterator<Led> iterator = listeLed.iterator(); iterator.hasNext();) {
			s+=  iterator.next().getId() + " | ";
			
		}
		
		System.out.println(s+"\n");
		
	}

	private void afficherResultat(List<Itr> listeItr, List<Led> listeLed) {
		
		String s ="|";
		
		for (Iterator<Itr> iterator = listeItr.iterator(); iterator.hasNext();) {
			
			s+=  " " + toInt(iterator.next().getEtat()) + " |";
			
		}
		
		s+="| ";
		
		for (Iterator<Led> iterator = listeLed.iterator(); iterator.hasNext();) {
			s+=  toInt(iterator.next().estAllume()) + " | ";
			
		}
		
		System.out.println(s);
		
	}

	private String toInt(Boolean b) {
		return (b) ? "1" : "0";
	}

	private void modifierItr(List<Itr> listeItr, int n) {
		
	
		int valeurRestante = n;
		
		for (int i = listeItr.size()-1; i >=0 ; i--) {
	
			if(valeurRestante>0 && valeurRestante>=Math.pow(2, i)){
				listeItr.get(i).setEtat(true);
				valeurRestante-=Math.pow(2, i);
			}
				
			else
				listeItr.get(i).setEtat(false);
			
		}
	}
	
	

}
