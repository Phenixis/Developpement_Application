package radioMonteCarlo.model;

import java.util.Collection;
import java.util.HashMap;

public class Tarif {
	Spectacle spectacle;
	Zone zone;
	
	double PleinTarif;
	
	public Tarif(Spectacle spectacle, Zone zone) {
		this.spectacle=spectacle;
		this.zone = zone;
	}
	
	public void ajoutPrix(Zone zone, int tarifZone) {
		PleinTarif=tarifZone;
		
	}
	
	
	
}