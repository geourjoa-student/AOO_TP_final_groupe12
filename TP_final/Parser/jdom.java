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
      Element circuit = new Element("Circuit");
      racine.addContent(circuit);
      Attribute nom = new Attribute("nom",c.nomCircuit);
      etudiant.setAttribute(nom);
      for(i=0;i<c.composants.size();i++)
      {
    	  Element composant = new Element("Composant");
          circuit.addContent(composant);
          Attribute idf = new Attribute("idf",c.composants.get(i).getId());
          composant.setAttribute(idf);
          Attribute type = new Attribute("type",c.composants.get(i).getClass().getName());
          composant.setAttribute(type);
          for(j=0;j<c.composants.get(i).getLength();j++)
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