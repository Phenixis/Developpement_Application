package radioMonteCarlo;

public class Representation {

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
        
    }
    
    public void Representation(Representation ancienne, Spectacle nouveauSpectacle) {
    	this.jour=ancienne.jour;
    	this.heure=ancienne.heure;
    	this.annulee=ancienne.annulee;
    	this.nbBilletVendu=ancienne.nbBilletVendu;
    	this.spectacle=nouveauSpectacle;
    		
    }

   public void ajoutSpectacle(Spectacle spectacle) {
	   if(this.spectacle==null) {
		   this.spectacle =spectacle;
	   }else {
		   Representation(this,spectacle);
	   }
	   
   }
   
   public void ajoutInformation(Information information) {
	   this.information=information;
   }
}