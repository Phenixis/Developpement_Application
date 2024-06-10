package radioMonteCarlo.model;

import java.util.ArrayList;

public class Representation {
	static public ArrayList<Representation> list = new ArrayList<>();

    private String jour;
    private String heure;
    private boolean annulee;
    private int nbBilletVendu;
    private Spectacle spectacle;
    private Information information;

    // Constructeurs
    
    public Representation(String jour, String heure, boolean annulee, int nbBilletVendu) {
        this.jour = jour;
        this.heure = heure;
        this.annulee = false;
        this.nbBilletVendu = nbBilletVendu;
        
        Representation.list.add(this);
        
    }
    
    public Representation(String jour, String heure, boolean annulee, int nbBilletVendu, Spectacle spectacle) {
    	this(jour, heure, annulee, nbBilletVendu);
    	
    	this.ajoutSpectacle(spectacle);
    }

    
    private Representation(Representation ancienne, Spectacle nouveauSpectacle) {
    	this(ancienne.jour, ancienne.heure, ancienne.annulee, ancienne.nbBilletVendu, nouveauSpectacle);		
    }
    
    // Fonctions Bas Niveau

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
		this.spectacle =spectacle;
		spectacle.ajoutRepresentation(this);
	}
   
   public void ajoutInformation(Information information) {
	   this.information=information;
   }
   
   public void remplacer(Spectacle nouveauSpectacle) {
   	this.annulee = true;
   	new Representation(this, nouveauSpectacle);
   }
   
   public void annuler() {
   	this.annulee=true;
   }
}
