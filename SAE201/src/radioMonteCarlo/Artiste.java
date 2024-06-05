package radioMonteCarlo;

import java.util.ArrayList;

public class Artiste {
	String nom;
	ArrayList<Spectacle> listeSpectacle=new ArrayList<>();
	public Artiste(String nom, ArrayList<Spectacle> listeSpectacle) {
		this.nom = nom;
		this.listeSpectacle = listeSpectacle;
	}
	public Artiste(String nom) {
		super();
		this.nom = nom;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Spectacle> getListeSpectacle() {
		return listeSpectacle;
	}
	public void ajouteSpectacle(Spectacle listeSpectacle) {
		this.listeSpectacle.add(listeSpectacle);
	}
	
	public void retirerSpectacle(Spectacle Spectacle) {
		if(this.listeSpectacle.size()!=1) {
		    if (this.listeSpectacle.contains(Spectacle)) {
		        this.listeSpectacle.remove(Spectacle);
		    } else {
		        System.out.println("Erreur : Spectacle spécifié n'est pas présent dans la liste.");
		    }
		}else {
			System.out.println("Erreur : minimum 1 Spectacle");
		}	
	}
	

}
