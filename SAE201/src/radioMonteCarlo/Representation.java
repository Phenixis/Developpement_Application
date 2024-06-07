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
    
    

   public static ArrayList<Representation> getList() {
		return list;
	}

	public static void setList(ArrayList<Representation> list) {
		Representation.list = list;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public boolean isAnnulee() {
		return annulee;
	}

	public void setAnnulee(boolean annulee) {
		this.annulee = annulee;
	}

	public int getNbBilletVendu() {
		return nbBilletVendu;
	}

	public void setNbBilletVendu(int nbBilletVendu) {
		this.nbBilletVendu = nbBilletVendu;
	}

	public Spectacle getSpectacle() {
		return spectacle;
	}

	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
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
