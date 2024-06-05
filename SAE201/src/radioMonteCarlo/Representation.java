package radioMonteCarlo;

import java.util.ArrayList;

public class Representation {
	static public ArrayList<Representation> list = new ArrayList<>();

    private String jour;
    private String heure;
    private boolean annulee;
    private int nbBilletVendu;
    private Spectacle spectacle;
    private Information information;

    public Representation(String jour, String heure, boolean annulee, int nbBilletVendu) {
        this.jour = jour;
        this.heure = heure;
        this.annulee = annulee;
        this.nbBilletVendu = nbBilletVendu;
        
        Representation.list.add(this);
    }
    
    public Representation(String jour, String heure, boolean annulee, int nbBilletVendu, Spectacle spectacle) {
    	this(jour, heure, annulee, nbBilletVendu);
    	
    	this.ajoutSpectacle(spectacle);
    }

    
    public Representation(Representation ancienne, Spectacle nouveauSpectacle) {
    	this(ancienne.jour, ancienne.heure, ancienne.annulee, ancienne.nbBilletVendu, nouveauSpectacle);
    		
    }

   public void ajoutSpectacle(Spectacle spectacle) {
	   if(this.spectacle==null) {
		   this.spectacle =spectacle;
	   }else {
		   new Representation(this,spectacle);
	   }
	   
   }
   
   public void ajoutInformation(Information information) {
	   this.information=information;
   }
}
