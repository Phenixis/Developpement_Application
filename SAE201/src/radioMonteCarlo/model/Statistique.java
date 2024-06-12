package radioMonteCarlo.model;

import java.util.ArrayList;

public class Statistique {
	public static Statistique calculerStats(Spectacle spec) {
		return new Statistique(spec);
	}
	
	private Spectacle spectacle;
	private String nomSpectacle; // valeur récupérée
	private int nbRepresentation; // valeur récupérée
	private int nbBillet=0; // valeur calculée
	private float moyBillet=0; // valeur calculée
	
	private Statistique(Spectacle spectacle) {
		this.nomSpectacle=spectacle.getNom();
		
		this.update();
		
		this.moyBillet=moyenneBillet();
	}
	
	public void update() {
		this.nbRepresentation=spectacle.getRepresentations().size();
		this.nbBillet=nombreBillet();
	}

	private int nombreBillet(){
		int nb=0;
		
		for(Representation i : this.spectacle.getRepresentations()){
			nb+=i.getNbBilletVendu();
		}
		
		return nb;
	}	

	private int moyenneBillet(){
		this.update();
		return nbBillet/nbRepresentation;
	}
	
	// Accesseurs
	public String getNomSpectacle() {
		return nomSpectacle;
	}

	public int getNbRepresentation() {
		this.update();
		return nbRepresentation;
	}

	public int getNbBillet() {
		this.update();
		return nbBillet;
	}

	public float getMoyBillet() {
		this.moyBillet = moyenneBillet();
		return moyBillet;
	}
}