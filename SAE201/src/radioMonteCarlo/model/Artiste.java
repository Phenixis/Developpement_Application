package radioMonteCarlo.model;

import java.util.ArrayList;

public class Artiste {
	static public ArrayList<Artiste> liste = new ArrayList<>();
	
	String nom;
	
	// Relation avec Spectacle
	ArrayList<Spectacle> listeSpectacle=new ArrayList<>();
	
	public Artiste(String nom) {
		this.nom = nom;
		
		Artiste.liste.add(this);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Relation avec Spectacle
	
	public boolean contientSpectacle(Spectacle spectacle) {
		return this.listeSpectacle.contains(spectacle);
	}
	
	private void addSpectacle(Spectacle spectacle) {
		this.listeSpectacle.add(spectacle);
	}
	
	private void removeSpectacle(Spectacle spectacle) {
		this.listeSpectacle.remove(spectacle);
	}
	
	public boolean retirerSpectacle(Spectacle spectacle) {
		if(this.listeSpectacle.size()!=1) {
		    if (this.contientSpectacle(spectacle)) {
		        this.removeSpectacle(spectacle);
		        spectacle.removeArtiste(this);
		        return true;
		    } else {
		        System.out.println("Erreur : Spectacle spécifié n'est pas présent dans la liste.");
		    }
		} else {
			System.out.println("Erreur : il faut au moins 1 spectacle");
		}	
		return false;
	}
	
	public boolean ajouterSpectacle(Spectacle spectacle) {
		if (this.contientSpectacle(spectacle)) {
			System.out.println("Erreur : L'artiste joue déjà dans le spectacle.");
			return false;
		} else {
			this.addSpectacle(spectacle);
			return true;
		}
	}
}
