package radioMonteCarlo.model;

import java.util.Collection;
import java.util.HashMap;

public class Tarif {
	Spectacle spectacle;
	Zone zone;
	int tarifZone;
	double PleinTarif;
	
	public Tarif(Spectacle spectacle, Zone zone,int tarifZone) {
		this.spectacle=spectacle;
		this.zone = zone;
		this.tarifZone=tarifZone;
	}
	
	
}