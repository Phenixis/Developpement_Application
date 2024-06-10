package radioMonteCarlo.model;

import java.util.ArrayList;

public class Statistique {
	Spectacle spectacle;
	private String nomSpectacle;
	private int nbRepresentation=0;
	private int nbBillet=0;
	private float moyBillet=0;
	
	private Statistique(Spectacle spectacle) {

		this.nomSpectacle=spectacle.getNom();
		this.nbRepresentation=spectacle.getListeRepresentations().size();
		this.nbBillet=nombreBillet(spectacle);
		this.moyBillet=moyenneBillet(spectacle);
	}
	
	static Statistique calculerStats(Spectacle spec) {
		return new Statistique(spec);
	}

	
	private int nombreBillet(Spectacle spectacle){
		int nb=0;
		for(Representation i : spectacle.getListeRepresentations() ){
			nb+=i.getNbBilletVendu();
		}
		return nb;
	}	

	private int moyenneBillet(Spectacle spectacle){
		int nb=0;
		nb=nbBillet/nbRepresentation;
		return nb;
	
	}

}