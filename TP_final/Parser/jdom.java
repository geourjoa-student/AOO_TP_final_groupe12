import java.io.*;
import org.jdom.*;
import org.jdom.output.*;
import projet.composant.Circuit;
public class JDOM
{

   static Element racine = new Element("Tout");

   static org.jdom.Document document = new Document(racine);

   public void createDoc(Circuit c)
   {
	  string nameClass;
      Element circuit = new Element("Circuit");
      racine.addContent(circuit);
      Attribute nom = new Attribute("nom",c.getNom);
      circuit.setAttribute(nom);
      for(i=0;i<c.composants.size();i++)
      {
    	  nameClass = c.composants.get(i).getClass().getName();
    	  if(nameClass == "Composite")
    	  {
    		  Element composite = new Element("Composite");
              racine.addContent(composite);
              Attribute nomComposite = new Attribute("nom",c.getNom());
              composite.setAttribute(nomComposite);
              Attribute entreesComposite = new Attribute("entrees",c.composants.get(i).portsEntrees.portsEntreeComposantsInternesConnectes.size());
              composite.setAttribute(entreesComposite);
              Attribute sortiesComposite = new Attribute("sorties",c.composants.get(i).getLengthSorties());
              composite.setAttribute(sortiesComposite);
              funComposite1(i,c.composants.get(i));
              
    	  }
    	  Element composant = new Element("Composant");
          circuit.addContent(composant);
          Attribute idf = new Attribute("idf",c.composants.get(i).getId());
          composant.setAttribute(idf);
          Attribute type = new Attribute("type",nameClass);
          composant.setAttribute(type);
          for(j=0;j<c.composants.get(i).getLengthSorties();j++)
          {
              Element connexion = new Element("Connexion");
              composant.addContent(connexion);  
              Attribute sortie = new Attribute("sortie",c.composants.get(i).getNiemePortSortie(j).getId());
              connexion.setAttribute(sortie); 
              for(k=0;k<c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().size();k++);
              {
            	  Element destination = new Element("Destination");
                  connexion.addContent(destination);  
                  Attribute composantdest = new Attribute("composant",c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getProprietairePort().getId());
                  destination.setAttribute(composantdest);
                  Attribute entree = new Attribute("entree",c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getId());
                  destination.setAttribute(entree);
              }
          }
          
      }
      
      private void funComposite1(int i,Circuit c){
          String nameClass;
    	  for(i=0;i<c.composants.size();i++)
          {
        	  nameClass = c.composants.get(i).getClass().getName();
        	  if(nameClass == "Composite")
        	  {
        		  Element composite = new Element("Composite");
                  racine.addContent(composite);
                  Attribute nomComposite = new Attribute("nom",c.getNom());
                  composite.setAttribute(nomComposite);
                  Attribute entreesComposite = new Attribute("entrees",c.composants.get(i).portsEntrees.portsEntreeComposantsInternesConnectes.size());
                  composite.setAttribute(entreesComposite);
                  Attribute sortiesComposite = new Attribute("sorties",c.composants.get(i).getLengthSorties());
                  composite.setAttribute(sortiesComposite);
                  funComposite2(i,c.composants.get(i));
        	  }
        	  Element composant = new Element("Composant");
              circuit.addContent(composant);
              Attribute idf = new Attribute("idf",c.composants.get(i).getId());
              composant.setAttribute(idf);
              Attribute type = new Attribute("type",nameClass);
              composant.setAttribute(type); 
          for(j=0;j<c.composants.get(i).getLengthSorties();j++)
          {
              Element connexion = new Element("Connexion");
              composant.addContent(connexion);  
              Attribute sortie = new Attribute("sortie",c.composants.get(i).getNiemePortSortie(j).getId());
              connexion.setAttribute(sortie); 
              for(k=0;k<c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().size();k++);
              {
            	  Element destination = new Element("Destination");
                  connexion.addContent(destination);  
                  Attribute composantdest = new Attribute("composant",c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getProprietairePort().getId());
                  destination.setAttribute(composantdest);
                  Attribute entree = new Attribute("entree",c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getId());
                  destination.setAttribute(entree);
              }
          }
    	  Element interfaceES = new Element("Interface");
          circuit.addContent(interface);
          for(x=0;x<c.composants.get(i).getLengthEntrees;x++)
          {
        	  Element entreesInterface = new Element("Entree");
              interfaceES.addContent(entreesInterface);  
              Attribute portNum = new Attribute("port",x+1);
              entreesInterface.setAttribute(portNum); 
          }
          Element sortieInterface = new Element("Sortie");
          interfaceES.addContent(entreesInterface);  
          Attribute interfaceNb = new Attribute("Interface",1);
          sortieInterface.setAttribute(interfaceNb); 
          Attribute composantCo = new Attribute("composante",c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getProprietairePort().getId());
          sortieInterface.setAttribute(composantCo); 
          Attribute entreeCo = new Attribute("entree",c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getId());
         sortieInterface.setAttribute(entreeCo);
      }
 }

      private void funComposite2(int i,Circuit c){
          String nameClass;
    	  for(i=0;i<c.composants.size();i++)
          {
        	  nameClass = c.composants.get(i).getClass().getName();
        	  if(nameClass == "Composite")
        	  {
        		  Element composite = new Element("Composite");
                  racine.addContent(composite);
                  Attribute nomComposite = new Attribute("nom",c.getNom());
                  composite.setAttribute(nomComposite);
                  Attribute entreesComposite = new Attribute("entrees",c.composants.get(i).portsEntrees.portsEntreeComposantsInternesConnectes.size());
                  composite.setAttribute(entreesComposite);
                  Attribute sortiesComposite = new Attribute("sorties",c.composants.get(i).getLengthSorties());
                  composite.setAttribute(sortiesComposite);
                  funComposite1(i,c.composants.get(i));
        	  }
        	  Element composant = new Element("Composant");
              circuit.addContent(composant);
              Attribute idf = new Attribute("idf",c.composants.get(i).getId());
              composant.setAttribute(idf);
              Attribute type = new Attribute("type",nameClass);
              composant.setAttribute(type); 
          for(j=0;j<c.composants.get(i).getLengthSorties();j++)
          {
              Element connexion = new Element("Connexion");
              composant.addContent(connexion);  
              Attribute sortie = new Attribute("sortie",c.composants.get(i).getNiemePortSortie(j).getId());
              connexion.setAttribute(sortie); 
              for(k=0;k<c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().size();k++);
              {
            	  Element destination = new Element("Destination");
                  connexion.addContent(destination);  
                  Attribute composantdest = new Attribute("composant",c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getProprietairePort().getId());
                  destination.setAttribute(composantdest);
                  Attribute entree = new Attribute("entree",c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getId());
                  destination.setAttribute(entree);
              }
          }
    	  Element interfaceES = new Element("Interface");
          circuit.addContent(interface);
          for(x=0;x<c.composants.get(i).getLengthEntrees;x++)
          {
        	  Element entreesInterface = new Element("Entree");
              interfaceES.addContent(entreesInterface);  
              Attribute portNum = new Attribute("port",x+1);
              entreesInterface.setAttribute(portNum); 
          }
          Element sortieInterface = new Element("Sortie");
          interfaceES.addContent(entreesInterface);  
          Attribute interfaceNb = new Attribute("Interface",1);
          sortieInterface.setAttribute(interfaceNb); 
          Attribute composantCo = new Attribute("composante",ccomposants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getProprietairePort().getId());
          sortieInterface.setAttribute(composantCo); 
          Attribute entreeCo = new Attribute("entree",c.composants.get(i).getNiemePortSortie(j).getListePortEntreeConnectes().get(k).getId());
         sortieInterface.setAttribute(entreeCo);
      }
 }
      
      static void affiche()
      {
         try
         {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, System.out);
         }
         catch (java.io.IOException e){}
      }

      static void enregistre(String fichier)
      {
         try
         {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, new FileOutputStream(fichier));
         }
         catch (java.io.IOException e){}
      }
      
      affiche();
      enregistre("output.xml");
   }
}