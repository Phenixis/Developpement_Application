package radioMonteCarlo;

public class Information {

    private int annee;
    private String nomSpectacle;
    private int nbRepresentation=0;
    private int totalBilletVendu=0;
    private Spectacle spectacle;
    private Statistique stat;
	public Information(Spectacle spectacle,Statistique stat) {
		this.spectacle=spectacle;
		spectacle.ajoutInformation(this);
		this.stat=stat;
		stat.ajoutInformation(this);
		
		this.nomSpectacle=this.spectacle.getNom();
	}

    
	public void misajour(Representation representation) {
		
			this.totalBilletVendu+=representation.getNbBilletVendu();
			this.nbRepresentation+=1;
			
		
	}


	
    
}
