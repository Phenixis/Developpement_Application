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
    
    public Representation(Representation ancienne, Spectacle nouveauSpectacle) {
    	
    }

   public void ajoutSpectacle(Spectacle spectacle) {
	   if(this.spectacle==null) {
		   this.spectacle =spectacle;
	   }else {
		   Representation(spectacle);
	   }
	   
   }
   
   public void ajoutInformation(Information information) {
	   this.information=information;
   }
}