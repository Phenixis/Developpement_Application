package radioMonteCarlo.model;

import java.util.ArrayList;

public class Representation {
	static public ArrayList<Representation> list = new ArrayList<>();
	
    private String date;
    private String heure;
    private boolean annulee;
    private int nbBilletVendu;
    private Spectacle spectacle;

    // Constructeurs
    
    public Representation(String date, String heure, boolean annulee, int nbBilletVendu) {
        this.date = date;
        this.heure = heure;
        this.annulee = false;
        this.nbBilletVendu = nbBilletVendu;
        
        Representation.list.add(this);
        
    }
    
    public Representation(String date, String heure, boolean annulee, int nbBilletVendu, Spectacle spectacle) {
    	this(date, heure, annulee, nbBilletVendu);
    	
    	this.setSpectacle(spectacle);
    }
    
    private Representation(Representation ancienne, Spectacle nouveauSpectacle) {
    	this(ancienne.date, ancienne.heure, ancienne.annulee, ancienne.nbBilletVendu, nouveauSpectacle);		
    }
    
    // Fonctions Bas Niveau

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	private void setNbBilletVendu(int nbBilletVendu) {
		this.nbBilletVendu = nbBilletVendu;
	}

	public Spectacle getSpectacle() {
		return spectacle;
	}
	
	private void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}
   
    public void remplacer(Spectacle nouveauSpectacle) {
    	this.annuler();
    	new Representation(this, nouveauSpectacle);
    }
   
    public void annuler() {
    	this.annulee=true;
    }
}
